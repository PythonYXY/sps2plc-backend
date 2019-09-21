package sps2plc.core.models.plc;

import sps2plc.core.models.sps.Property;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.sps.Scope;
import sps2plc.core.models.sps.expressions.*;
import sps2plc.core.models.translators.Pattern;
import sps2plc.core.utils.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class ILCode {

    private final List<ScopeCode> scopeCodes;
    private final List<ScopeCode> patternScopeCodes; // for unit testing
    private final List<Requirement> requirements;
    private List<List<String>> circularDependencyRequirements;
    private Map<String, List<String>> circularDependencyTable;

    private Map<String, List<String>> conflictedRequirements;
    private final Map<String, Requirement> reqId2Requirement;

    private StringBuilder generatedILCode;


    public ILCode() {
        scopeCodes = new ArrayList<>();
        patternScopeCodes = new ArrayList<>();
        requirements = new ArrayList<>();
        reqId2Requirement = new HashMap<>();
        conflictedRequirements = new HashMap<>();
        generatedILCode = new StringBuilder();
    }

    public List<ScopeCode> getScopeCodes() { return scopeCodes; }

    public List<ScopeCode> getPatternScopeCodes() { return patternScopeCodes; }

    public List<Requirement> getRequirements() { return requirements; }

    public List<List<String>> getCircularDependencyRequirements() { return circularDependencyRequirements; }

    public Map<String, List<String>> getCircularDependencyTable() { return circularDependencyTable; }

    public Map<String, List<String>> getConflictedRequirements() { return conflictedRequirements; }

    public String getGeneratedILCode() { return generatedILCode.toString(); }

    private Map<String, ScopeCode> getReq2ScopeCode() {
        Map<String, ScopeCode> req2ScopeCode = new LinkedHashMap<>();
        for (int index = 0; index < scopeCodes.size(); index++) {
            req2ScopeCode.put(requirements.get(index).getReqId(), scopeCodes.get(index));
        }
        return req2ScopeCode;
    }

    public void addRequirement(Requirement requirement) {
        requirements.add(requirement);
        reqId2Requirement.put(requirement.getReqId(), requirement);
    }


    public void replaceExpressions(List<Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>>> scopeExpressionILCodes,
                      Pattern pattern) {

        patternScopeCodes.add(pattern.getScopeCode());
        ScopeCode scopeCode = pattern.getScopeCode().clone();
        List<AbstractMap.SimpleEntry<String, String>> codes = scopeCode.getCodes();
        List<AbstractMap.SimpleEntry<String, String>> newCodes = new ArrayList<>();
        List<String> expressions = scopeCode.getExpressions();

        for (AbstractMap.SimpleEntry<String, String> line: codes) {
            if (expressions.contains(line.getValue())) {
                int index = expressions.indexOf(line.getValue());
                switch (line.getKey()) {
                    case "LD":
                        newCodes.addAll(scopeExpressionILCodes.get(index).get(true));
                        break;
                    case "LDN":
                        newCodes.addAll(scopeExpressionILCodes.get(index).get(false));
                        break;
                    case "AN":
                        newCodes.addAll(scopeExpressionILCodes.get(index).get(false));
                        newCodes.add(new AbstractMap.SimpleEntry<>("ALD", ""));
                        break;
                    default:
                        throw new RuntimeException("The instruction in IL code corresponding to the scope expression is: " + line.getKey());
                }
            } else {
                newCodes.add(line);
            }
        }
        scopeCode.setCodes(newCodes);
        scopeCodes.add(scopeCode);
    }

    /**
     * All intermediates in scope code are in the form of M5.*, start with M5.0
     */
    public void replaceIntermediates() {
        int counter = 0;
        for (ScopeCode scopeCode: scopeCodes) {
            for (int index = 0; index < scopeCode.getIntermediates().size(); index++) {
                String intermediate = scopeCode.getIntermediates().get(index);
                String replacement = "M5." + counter++;
                for (AbstractMap.SimpleEntry<String, String> line: scopeCode.getCodes()) {
                    if (line.getValue().equals(intermediate)) {
                        line.setValue(replacement);
                    }
                }
//                scopeCode.getIntermediates().set(index, replacement);
            }
        }
    }

    /**
     * All timers in scope code are in the form of T*, start with T37
     * @param requirements the list of requirements
     */
    public void replaceTimers()  {
        int counter = 37;
        for (int scopeCodeIndex = 0; scopeCodeIndex < scopeCodes.size(); scopeCodeIndex++) {
            for (int timeIndex = 0; timeIndex < scopeCodes.get(scopeCodeIndex).getTimers().size(); timeIndex++) {
                AbstractMap.SimpleEntry<String, String> timerMap = scopeCodes.get(scopeCodeIndex).getTimers().get(timeIndex);
                String timer = timerMap.getKey();
                String time = timerMap.getValue();

                String timerReplacement = "T" + counter++;

                List<Expression> timeExprs = requirements.get(scopeCodeIndex).getDelay().getExpressions();
                String timeReplacement = time.replaceAll(
                        "t1",
                        String.valueOf(((NumberExpression)(timeExprs.get(0))).getValue())
                );

                if (timeExprs.size() > 1) {
                    timeReplacement = timeReplacement.replaceAll(
                            "t2",
                            String.valueOf(((NumberExpression)(timeExprs.get(1))).getValue())
                    );
                }

                for (AbstractMap.SimpleEntry<String, String> line: scopeCodes.get(scopeCodeIndex).getCodes()) {
                    if (line.getValue().contains(timer)) {
                        line.setValue(line.getValue().replaceAll(timer, timerReplacement));
                    }

                    if (line.getValue().contains(time)) {
                        line.setValue(line.getValue().replaceAll(time, timeReplacement));
                    }
                }
            }
        }
    }

    private Graph generateDependencyGraph(List<Requirement> requirements) {
        Graph graph = new Graph();
        for (int i = 0; i < requirements.size(); i++) {
            for (int j = i + 1; j < requirements.size(); j++) {
                if (requirements.get(i).isDependsOn(requirements.get(j))) {
//                    System.out.println("add edge:" + requirements.get(j).getReqId() + ", " + requirements.get(i).getReqId());
                    graph.addEdge(requirements.get(j).getReqId(), requirements.get(i).getReqId());
                }

                if (requirements.get(j).isDependsOn(requirements.get(i))) {
//                    System.out.println("add edge:" + requirements.get(i).getReqId() + ", " + requirements.get(j).getReqId());
                    graph.addEdge(requirements.get(i).getReqId(), requirements.get(j).getReqId());
                }
            }
        }

        return graph;
    }


    public boolean hasCircularDependency() {
        Graph graph = generateDependencyGraph(requirements);
        circularDependencyRequirements = graph.getCircles();
        circularDependencyTable = graph.getCircularDependencyTable();
        return circularDependencyRequirements.size() != 0;
    }

    public boolean hasConflict() {
        boolean flag = false;

        for (int i = 0; i < requirements.size(); i++) {
            String tar1 = requirements.get(i).getTarget();
            if (conflictedRequirements.get(tar1) == null) {
                for (int j = 0; j < requirements.size(); j++) {
                    if (i != j) {
                        String tar2 = requirements.get(j).getTarget();
                        if (tar2.equals(tar1)) {
                            flag = true;
                            if (conflictedRequirements.get(tar1) == null) {
                                conflictedRequirements.put(tar1, new ArrayList<>(Collections.singleton(requirements.get(i).getReqId())));
                            }

                            conflictedRequirements.get(tar1).add(requirements.get(j).getReqId());
                        }
                    }
                }
            }
        }
        return flag;
    }


    /**
     *  All output intermediates for requirements with Absence property are in the form of M6.*
     */
    public void replaceOutput() {
        int counter = 0;

        for (int index = 0; index < requirements.size(); index++) {
             String target = requirements.get(index).getTarget();
             String output = scopeCodes.get(index).getOutput();

             switch(requirements.get(index).getProperty().getType()) {
                 case ABSENCE:
                     String intermediate = "M6." + counter++;
                     for (AbstractMap.SimpleEntry<String, String> line: scopeCodes.get(index).getCodes()) {
                         if (line.getValue().equals(output)) line.setValue(intermediate);
                     }
                     scopeCodes.get(index).getCodes().add(new AbstractMap.SimpleEntry<>("LDN", intermediate));
                     scopeCodes.get(index).getCodes().add(new AbstractMap.SimpleEntry<>("=", target));
                     break;
                 case UNIVERSALITY:
                     for (AbstractMap.SimpleEntry<String, String> line: scopeCodes.get(index).getCodes()) {
                         if (line.getValue().equals(output)) line.setValue(target);
                     }
                     break;

                 case EXISTENCE:
                     //TODO: add support for existence property
                     throw new RuntimeException("Not supported property type: existence");
             }
        }
    }

    /**
     * All intermediate output for conflicted requirements are in the form of M7.*
     * @param conflictedRequirements map target to the list of conflicted requirements
     * @return
     */
    public List<Expression> handleConflictedRequirements(Map<String, List<String>> conflictedRequirements) {
        int intermediateCounter = 0;
        int reqIdCounter = 1;
        List<Expression> ret = new ArrayList<>();

        Map<String, ScopeCode> req2ScopeCode = getReq2ScopeCode();

        for (Map.Entry<String, List<String>> entry: conflictedRequirements.entrySet()) {
            String target = entry.getKey();
            List<Requirement> conflictedReqList = new ArrayList<>();
            for (String reqId: entry.getValue()) conflictedReqList.add(reqId2Requirement.get(reqId));

            for (Requirement req: conflictedReqList) {
                String intermediate = "M7." + intermediateCounter++;
                req.setTarget(intermediate);

                String output = req2ScopeCode.get(req.getReqId()).getOutput();
                for (AbstractMap.SimpleEntry<String, String> line: req2ScopeCode.get(req.getReqId()).getCodes()) {
                    if (line.getValue().equals(output)) line.setValue(intermediate);
                }
            }

            Expression scopeExpr = new VariableExpression(conflictedReqList.get(0).getTarget());

            for (int index = 1; index < conflictedReqList.size(); index++) {
                switch (conflictedReqList.get(index).getProperty().getType()) {
                    case ABSENCE:
                        scopeExpr = new BooleanExpression(
                                scopeExpr,
                                new UnaryExpression(
                                    new VariableExpression(conflictedReqList.get(index).getTarget()),
                                    UnaryExpression.Operator.NOT
                                ),
                                BooleanExpression.Operator.AND
                        );
                        break;
                    case UNIVERSALITY:
                        scopeExpr = new BooleanExpression(
                                scopeExpr,
                                new VariableExpression(conflictedReqList.get(index).getTarget()),
                                BooleanExpression.Operator.OR
                        );
                        break;
                    case EXISTENCE:
                        //TODO: add support for existence property
                        throw new RuntimeException("Not supported property type: existence");
                }
            }

            Scope scope = new Scope(Scope.Type.WHEN, Arrays.asList(scopeExpr));
            Property property = new Property(Property.Type.UNIVERSALITY, new VariableExpression(target));
            Requirement newRequirement = new Requirement(scope, property);
            newRequirement.setReqId("E" + reqIdCounter++);
            requirements.add(newRequirement);
            ret.add(scopeExpr);
        }
        return ret;
    }

    public void handleConflictedScopeCodes(List<Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>>> conflictedScopeExpressionILCodes) {
        for (Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>> item: conflictedScopeExpressionILCodes) {
            ScopeCode newScopeCode = new ScopeCode();
            newScopeCode.setOutput("P");
            newScopeCode.setCodes(item.get(true));
            newScopeCode.addCode(new AbstractMap.SimpleEntry<>("=", "P"));

            scopeCodes.add(newScopeCode);
        }
    }

    public void generateILCode() {
        Graph graph = generateDependencyGraph(requirements);
        Map<String, ScopeCode> req2ScopeCode = getReq2ScopeCode();
        graph.topologicalSort();

        generatedILCode.append("This is the IL code for the PLC program.\n\n");

        for (String reqId: graph.getSortedResult()) {
            String code = req2ScopeCode.get(reqId).getCodes().stream().map(entry ->
                    entry.getKey() + " " + entry.getValue()).collect(Collectors.joining("\n")
            );
            generatedILCode.append(code + "\n\n");
        }
    }
}
