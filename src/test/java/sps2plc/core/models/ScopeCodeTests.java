package sps2plc.core.models;

import sps2plc.core.models.plc.ScopeCode;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;


public class ScopeCodeTests {

    @Test
    public void ScopeCodeTest1() {

        String json = "{\n" +
                "      \"expressions\": [\"Q\", \"R\"],\n" +
                "      \"intermediates\": [\"M0\"],\n" +
                "      \"output\": \"P\",\n" +
                "      \"timers\": [{\"Tn1\": \"t1\"}, {\"Tn2\": \"t2-t1\"}],\n" +
                "      \"code\":[\n" +
                "        {\"LD\": \"Q\"},\n" +
                "        {\"O\": \"M0\"},\n" +
                "        {\"AN\": \"R\"},\n" +
                "        {\"AN\": \"Tn2\"},\n" +
                "        {\"=\": \"M0\"},\n" +
                "        {\"LD\": \"M0\"},\n" +
                "        {\"TON\": \"Tn1,t1\"},\n" +
                "        {\"LD\": \"Tn1\"},\n" +
                "        {\"TON\": \"Tn2,t2-t1\"},\n" +
                "        {\"LD\": \"Tn1\"},\n" +
                "        {\"=\": \"P\"}\n" +
                "      ]\n" +
                "    }";

        JSONObject scopeCodeJsonObj = new JSONObject(json);
        ScopeCode scopeCode = ScopeCode.getScopeCode(scopeCodeJsonObj);
        printScopeCode(scopeCode);
    }

    private void printScopeCode(ScopeCode scopeCode) {
        System.out.println("expressions: ");
        for (String expression: scopeCode.getExpressions()) System.out.print(expression + ", ");
        System.out.println();
        System.out.println();

        System.out.println("intermediates: ");
        for (String intermediate: scopeCode.getIntermediates()) System.out.print(intermediate + ", ");
        System.out.println();
        System.out.println();

        System.out.println("timers: ");
        for (AbstractMap.SimpleEntry<String, String> timer: scopeCode.getTimers()) System.out.print(timer + ", ");
        System.out.println();
        System.out.println();

        System.out.println("codes: ");
        for (AbstractMap.SimpleEntry<String, String> code: scopeCode.getCodes()) System.out.println(code);
        System.out.println();
        System.out.println();
    }
}
