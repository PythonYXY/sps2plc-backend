package sps2plc.core.models.plc;

import sps2plc.core.models.sps.Property;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.sps.Scope;
import sps2plc.core.models.sps.expressions.*;
import sps2plc.core.models.translators.Pattern;
import sps2plc.core.utils.Graph;

import java.util.*;
import java.util.regex.Matcher;
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
        Map<String, ScopeCode> req2ScopeCode = new HashMap<>();
        for (int index = 0; index < scopeCodes.size(); index++) {
            req2ScopeCode.put(requirements.get(index).getReqId(), scopeCodes.get(index));
        }
        return req2ScopeCode;
    }

    private Map<String, Requirement> getReqId2Requirement() {
        Map<String, Requirement> reqId2Requirement = new HashMap<>();
        for (Requirement requirement : requirements) {
            reqId2Requirement.put(requirement.getReqId(), requirement);
        }
        return reqId2Requirement;
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

        // add nodes
        for (int i = 0; i < requirements.size(); i++) {
            graph.addNode(requirements.get(i).getReqId());
        }

        // add edges
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
     * @param priorityArray priority of requirements provided by user
     * @return
     */
    public List<Expression> handleConflictedRequirements(List<List<String>> priorityArray) {
        int intermediateCounter = 0;
        int reqIdCounter = 1;
        List<Expression> ret = new ArrayList<>();

        Map<String, ScopeCode> req2ScopeCode = getReq2ScopeCode();

        for (List<String> array: priorityArray) {
            String target = reqId2Requirement.get(array.get(0)).getTarget();
            List<Requirement> conflictedReqList = new ArrayList<>();
            for (String reqId: array) conflictedReqList.add(reqId2Requirement.get(reqId));

            for (Requirement req: conflictedReqList) {
                String intermediate = "M7." + intermediateCounter++;
                req.setTarget(intermediate);

                String output = req2ScopeCode.get(req.getReqId()).getOutput();
                req2ScopeCode.get(req.getReqId()).setOutput(intermediate);
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
            newRequirement.setText("Priority combination code: (" + String.join("<", array) + ")");
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

    /**
     * All intermediate output for interlocked requirements are in the form of M8.*
     * @param interlockRequirements the list of requirement with interlock property
     */
    public void handleInterlock(List<Requirement> interlockRequirements) {
        int counter = 0;
        Map<String, ScopeCode> req2ScopeCode = getReq2ScopeCode();

        for (Requirement interlockRequirement: interlockRequirements) {
            List<String> intermediates = new ArrayList<>(Arrays.asList("M8." + counter++, "M8." + counter++));
            List<String> targets = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                String target = interlockRequirement.getProperty().getExpression().getVariables().get(i);
                targets.add(target);
                for (Requirement requirement: requirements) {
                    if (requirement.getProperty().getExpression().getVariables().get(0).equals(target)) {
                        requirement.setTarget(intermediates.get(i));

                        String anotherTarget = interlockRequirement.getProperty().getExpression().getVariables().get(1 - i);
                        final int finalI = i;
                        requirement.getScope().getExpressions().forEach(expr -> expr.replaceVariableExpression(target, intermediates.get(finalI)));
                        requirement.getScope().getExpressions().forEach(expr -> expr.replaceVariableExpression(anotherTarget, intermediates.get(1 - finalI)));

                        ScopeCode scopeCode = req2ScopeCode.get(requirement.getReqId());
                        scopeCode.setOutput(intermediates.get(i));
                        for (Map.Entry<String, String> line: scopeCode.getCodes()) {
                            if (line.getValue().equals(target)) line.setValue(intermediates.get(i));
                            if (line.getValue().equals(anotherTarget)) line.setValue(intermediates.get(1 - i));
                        }
                        interlockRequirement.getScope().getExpressions().add(new VariableExpression(intermediates.get(i)));
                        break;
                    }
                }
            }

            ScopeCode scopeCode = new ScopeCode();
            scopeCode.setCodes(new ArrayList<>(Arrays.asList(
                    new AbstractMap.SimpleEntry<>("LDN", intermediates.get(1)),
                    new AbstractMap.SimpleEntry<>("O", targets.get(0)),
                    new AbstractMap.SimpleEntry<>("A", intermediates.get(0)),
                    new AbstractMap.SimpleEntry<>("=", targets.get(0)),
                    new AbstractMap.SimpleEntry<>("LDN", intermediates.get(0)),
                    new AbstractMap.SimpleEntry<>("O", targets.get(1)),
                    new AbstractMap.SimpleEntry<>("A", intermediates.get(1)),
                    new AbstractMap.SimpleEntry<>("=", targets.get(1))
            )));

            interlockRequirement.setText("Interlock code (" + targets.get(0) + " and " + targets.get(1) + ")");
            requirements.add(interlockRequirement);
            scopeCodes.add(scopeCode);
        }
    }

    public void generateILCode(Map<String, String> ioMap) {
        Graph graph = generateDependencyGraph(requirements);
        Map<String, ScopeCode> req2ScopeCode = getReq2ScopeCode();
        Map<String, Requirement> reqId2Requirement = getReqId2Requirement();
        graph.topologicalSort();

        generatedILCode.append("# This is the IL code for the PLC program.\n\n");

        Map<String, String> reversedIOMap = new HashMap<>();
        List<String> ioArr = new ArrayList<>();
        for (Map.Entry<String, String> entry : ioMap.entrySet()) {
            reversedIOMap.putIfAbsent(entry.getValue(), entry.getKey());
            ioArr.add(entry.getValue());
        }

        System.out.println(reversedIOMap);
        System.out.println(ioArr);

        for (String reqId: graph.getSortedResult()) {
            String reqStr = reqId2Requirement.get(reqId).getText();

            for (String io: ioArr) reqStr = reqStr.replace(io, io + "(" + reversedIOMap.get(io) + ")");

            generatedILCode.append("# " + reqStr + '\n');
            String code = req2ScopeCode.get(reqId).getCodes().stream().map(entry ->
                    entry.getKey() + "\t" + entry.getValue()).collect(Collectors.joining("\n")
            );
            generatedILCode.append(code + "\n\n");
        }
    }
}
