package sps2plc.core.models.plc;

import org.json.JSONObject;

import org.json.JSONArray;

import java.util.*;

public class ScopeCode {

    private final List<String> expressions;
    private final List<String> intermediates;
    private final List<AbstractMap.SimpleEntry<String, String>> timers;
    private List<AbstractMap.SimpleEntry<String, String>> codes;

    private String output;

    public ScopeCode() {
        expressions = new ArrayList<>();
        intermediates = new ArrayList<>();
        timers = new ArrayList<>();
        codes = new ArrayList<>();
    }

    @Override
    public ScopeCode clone() {
        ScopeCode newObj = new ScopeCode();
        newObj.expressions.addAll(this.expressions);
        newObj.intermediates.addAll(this.intermediates);
        this.timers.forEach(map -> newObj.timers.add(new AbstractMap.SimpleEntry<>(map.getKey(), map.getValue())));
        this.codes.forEach(map -> newObj.codes.add(new AbstractMap.SimpleEntry<>(map.getKey(), map.getValue())));
        newObj.setOutput(this.output);
        return newObj;
    }

    public List<String> getExpressions() {
        return expressions;
    }

    public List<String> getIntermediates() {
        return intermediates;
    }

    public List<AbstractMap.SimpleEntry<String, String>> getTimers() {
        return timers;
    }

    public List<AbstractMap.SimpleEntry<String, String>> getCodes() {
        return codes;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) { this.output = output; }

    public static ScopeCode getScopeCode(JSONObject scopeCode) {
        ScopeCode newScopeCode = new ScopeCode();

        JSONArray expressionsJsonArr = scopeCode.getJSONArray("expressions");
        for (int i = 0; i < expressionsJsonArr.length(); i++) {
            newScopeCode.addExpression(expressionsJsonArr.getString(i));
        }

        JSONArray intermediatesJsonArr = scopeCode.getJSONArray("intermediates");
        for (int i = 0; i < intermediatesJsonArr.length(); i++) {
            newScopeCode.addIntermediate(intermediatesJsonArr.getString(i));
        }

        newScopeCode.setOutput(scopeCode.getString("output"));

        JSONArray timersJsonArr = scopeCode.getJSONArray("timers");
        for (int i = 0; i < timersJsonArr.length(); i++) {
            String name = timersJsonArr.getJSONObject(i).keys().next();
            String value = timersJsonArr.getJSONObject(i).getString(name);
            newScopeCode.addTimer(new AbstractMap.SimpleEntry<>(name, value));
        }

        JSONArray codeJsonArr = scopeCode.getJSONArray("code");
        for (int i = 0; i < codeJsonArr.length(); i++) {
            String instruction = codeJsonArr.getJSONObject(i).keys().next();
            String operand = codeJsonArr.getJSONObject(i).getString(instruction);
            newScopeCode.addCode(new AbstractMap.SimpleEntry<>(instruction, operand));
        }

        return newScopeCode;
    }

    public void addExpression(String expression) {
        expressions.add(expression);
    }

    public void addIntermediate(String intermediate) {
        intermediates.add(intermediate);
    }

    public void addTimer(AbstractMap.SimpleEntry<String, String> timer) {
        timers.add(timer);
    }

    public void addCode(AbstractMap.SimpleEntry<String, String> code) {
        codes.add(code);
    }

    public void setCodes(List<AbstractMap.SimpleEntry<String, String>> codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        return "expressions:" +
                expressions + "\n" +
                "intermediates:" +
                intermediates + "\n" +
                "output:" +
                output + "\n" +
                "timers:" +
                timers + "\n" +
                "codes:" +
                codes + "\n";
    }
}
