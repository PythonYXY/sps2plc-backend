package sps2plc.core.models.translators;

import sps2plc.core.models.plc.ILCode;
import sps2plc.core.models.sps.Property;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.sps.expressions.*;

import java.util.*;

public class SPS2PLC implements ExpressionVisitor {

    private final Map<String, Pattern> patternMap = Pattern.loadPattern(Pattern.PATTERNS_FILE);

    private ILCode ilCode;

    private List<AbstractMap.SimpleEntry<String, String>> ilCodeList;

    public SPS2PLC() { }

    public ILCode translate(List<Requirement> requirements, List<List<String>> priorityArray) {
        ilCode = new ILCode();
        List<Requirement> interlockRequirements = new ArrayList<>();

        requirements.forEach(requirement -> {
            if (requirement.getProperty().getType() == Property.Type.INTERLOCK) {
                interlockRequirements.add(requirement);
            } else {
                ilCode.addRequirement(requirement);
            }
        });

        if (ilCode.hasCircularDependency()) {
            System.out.println("Circular dependency detected!");
            return ilCode;
        }

        if (priorityArray == null) {
            if (ilCode.hasConflict()) return ilCode;
        }

        for (Requirement requirement: ilCode.getRequirements()) {
            Pattern pattern = patternMap.get(requirement.key());
            if (pattern == null) {
                throw new RuntimeException("Pattern " + requirement.key() + " not found!");
            }

            List<Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>>> scopeExpressionILCodes = parseScopeExpressions(requirement.getScope().getExpressions());
            ilCode.replaceExpressions(scopeExpressionILCodes, pattern);
        }

        ilCode.replaceIntermediates();
        ilCode.replaceTimers();

        if (priorityArray != null) {
            List<Expression> conflictedScopeExpression = ilCode.handleConflictedRequirements(priorityArray);
            ilCode.handleConflictedScopeCodes(parseScopeExpressions(conflictedScopeExpression));
        }
        ilCode.replaceOutput();
        ilCode.handleInterlock(interlockRequirements);
        ilCode.generateILCode();

        return ilCode;
    }

    /**
     *
     * @param expressions 待转换的表达式列表
     * @return 转换后的IL代码列表，每个表达式对应两种IL代码：分别是原表达式的IL代码以及原表达式取反后的IL代码
     */
    private List<Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>>> parseScopeExpressions(List<Expression> expressions) {
        List<Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>>> scopeExpressionILCodes = new ArrayList<>();
        for (Expression expr: expressions) {
            Map<Boolean, List<AbstractMap.SimpleEntry<String, String>>> scopeILCodeMap = new HashMap<>();

            ilCodeList = new ArrayList<>();
            expr.accept(this, null);
            scopeILCodeMap.put(true, ilCodeList);

            ilCodeList = new ArrayList<>();
            expr.negateExpression().accept(this, null);
            scopeILCodeMap.put(false, ilCodeList);

            scopeExpressionILCodes.add(scopeILCodeMap);
        }

        return scopeExpressionILCodes;
    }

    @Override
    public void visitBooleanExpression(BooleanExpression expression, BooleanExpression.Operator operator) {
        Expression leftExpr = expression.getLeftExpr();
        Expression rightExpr = expression.getRightExpr();

        if (leftExpr instanceof BooleanExpression) {
            leftExpr.accept(this, null);
            rightExpr.accept(this, expression.getOperator());

            if (operator != null) {
                String operatorText = operator == BooleanExpression.Operator.AND ? "A" : "O";
                ilCodeList.add(new AbstractMap.SimpleEntry<>(operatorText + "LD", ""));
            }
        } else if (leftExpr instanceof UnaryExpression || leftExpr instanceof VariableExpression) {

            String not = "";
            if (leftExpr instanceof UnaryExpression) {
                leftExpr = ((UnaryExpression) leftExpr).getExpr();
                if (!(leftExpr instanceof VariableExpression)) throw new RuntimeException("Unary expression contains a non-variable expression!");
                not = "N";
            }

            if (operator != null) {
                String operatorText = operator == BooleanExpression.Operator.AND ? "A" : "O";

                if (expression.getOperator() == operator) {
                    ilCodeList.add(new AbstractMap.SimpleEntry<>(operatorText + not, ((VariableExpression) leftExpr).getName()));
                    rightExpr.accept(this, expression.getOperator());
                } else {
                    ilCodeList.add(new AbstractMap.SimpleEntry<>("LD" + not, ((VariableExpression) leftExpr).getName()));
                    rightExpr.accept(this, expression.getOperator());
                    ilCodeList.add(new AbstractMap.SimpleEntry<>(operatorText + "LD", ""));
                }
            } else {
                ilCodeList.add(new AbstractMap.SimpleEntry<>("LD" + not, ((VariableExpression) leftExpr).getName()));
                rightExpr.accept(this, expression.getOperator());
            }
        }
    }

    @Override
    public void visitNumberExpression(NumberExpression expression, BooleanExpression.Operator operator) {
        throw new RuntimeException("Requirement scope contains number expression.");
    }

    @Override
    public void visitUnaryExpression(UnaryExpression expression, BooleanExpression.Operator operator) {
        Expression varExpr = expression.getExpr();
        if (!(varExpr instanceof VariableExpression)) throw new RuntimeException("Unary expression contains a non-variable expression.");
        ilCodeList.add(new AbstractMap.SimpleEntry<>(
                operator == null ? "LDN" : (operator == BooleanExpression.Operator.AND ? "AN": "ON"),
                ((VariableExpression) varExpr).getName()
        ));
    }

    @Override
    public void visitVariableExpression(VariableExpression expression, BooleanExpression.Operator operator) {
        ilCodeList.add(new AbstractMap.SimpleEntry<>(
                operator == null ? "LD" : (operator == BooleanExpression.Operator.AND ? "A" : "O"),
                expression.getName()));
    }
}
