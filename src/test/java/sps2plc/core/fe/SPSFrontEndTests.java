package sps2plc.core.fe;

import sps2plc.core.models.plc.ILCode;
import sps2plc.core.models.plc.ScopeCode;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.sps.Scope;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SPSFrontEndTests {

    public static final String case1 = "[1]After I0.0 until (I0.1 or I0.2), Q0.0 is true.\n" +
            "[2]After I0.1, delayL=0, delayR=30, Q0.1 is true.\n" +
            "[3]After I0.0 until (I0.1 or I0.2), Q0.1 is false.\n" +
            "[4]After I0.1, delayL=0, delayR=30, Q0.0 is false.";

    // circular dependency version: change [2] to "When M0.1, delayL=5, M0.0 is true."
    public static final String case2 = "[1]When (I0.0 and not M0.0), delayL=5, M0.1 is true.\n" +
            "[2]When (I0.0 and not M0.0), delayL=10, M0.0 is true.\n" +
            "[3]When M0.1, Q0.0 is true.\n" +
            "[4]After I0.1 until not I0.0, Q0.0 is true.\n" +
            "[5]When I0.2, Q0.0 is true.\n" +
            "[6]When I0.0, Q0.1 is true.\n" +
            "[7]After I0.1 until not I0.0, Q0.1 is false.\n";

    public static final String case3 =
            "\n" +
                    "[1]After I0.1 until (I1.1 or not I0.0), Q0.2 is true.\n" +
                    "[2]After I0.2 until (I0.3 or not Q0.2), Q0.3 is true.\n" +
                    "[3]After I0.2 until ((I0.3 or Q0.4) or not I0.0), delayL = 0, delayR = 30, Q0.5 is true.\n" +
                    "[4]After I0.2 until (I0.3 or not Q0.2), delayL = 30, Q0.4 is true.\n" +
                    "[5]After I0.2 until ((I0.3 or Q0.4) or not I0.0), delayL = 0, delayR = 30, Q0.4 is false.\n" +
                    "\n" +
                    "[6]When (not Q2.1 and (not Q1.3 and (I1.2 and Q0.2))), Q0.7 is true.\n" +
                    "[7]When (not Q2.1 and (not Q1.3 and (I1.3 and Q0.2))), Q0.6 is true.\n" +
                    "[8]When (not Q2.1 and (not Q1.3 and (I1.2 and Q0.2))), Q0.6 is false.\n" +
                    "[9]When (not Q2.1 and (not Q1.3 and (I1.3 and Q0.2))), Q0.7 is false.\n" +
                    "\n" +
                    "[10]When (I0.4 and (not I2.2 and Q0.2)), Q1.0 is true.\n" +
                    "[11]When (I0.5 and (not I2.3 and Q0.2)), Q1.1 is true.\n" +
                    "[12]When (I0.4 and (not I2.2 and Q0.2)), Q1.1 is false.\n" +
                    "[13]When (I0.5 and (not I2.3 and Q0.2)), Q1.0 is false.\n" +
                    "\n" +
                    "[14]When ((not Q2.1 or I2.0) and ((Q2.1 or Q2.0) and (not I0.6 and (not I2.4 and (not Q1.4 and (not M0.4 and Q0.2)))))), Q1.2 is true.\n" +
//                    "[15]When (I0.7 and (not Q1.5 and (not Q1.2 and (not Q0.6 and (not Q0.7 and Q0.2))))), Q1.2 is true.\n" +
                    "[16]When (I1.7 and Q0.2), Q1.4 is true.\n" +
                    "\n" +
                    "[17]After (I0.1 and I1.4) until (Q2.1 or (I2.5 or I1.0)), delayL=0, delayRE=10, Q1.5 is true.\n" +
                    "[18]After (I0.1 and I1.4) until (Q2.1 or (I2.5 or I1.0)), delayL=0, delayRE=10, Q1.7 is true.\n" +
                    "[19]When (not Q0.2 or (I0.7 and (not Q1.5 and (not Q1.2 and (not Q0.6 and (not Q0.7 and Q0.2)))))), Q1.5 is false.\n" +
                    "[20]When (not Q0.2 or Q1.2), Q1.7 is false.\n" +
                    "\n" +
                    "[21]When I2.6, Q2.1 is false.\n" +
                    "[22]When I1.5, Q1.6 is true.\n" +
                    "[23]When Q1.6, Q2.0 is true.\n" +
                    "[24]When Q1.6, Q2.2 is false.";

//    public static final String case3 =
//            "[1]After I0.1 until (I1.1 or not I0.0), Q0.2 is true.\n" +
//                    "[2]After I0.2 until (I0.3 or not Q0.2), Q0.3 is true.\n" +
//                    "[3]After I0.2 until ((I0.3 or Q0.4) or not I0.0), delayL = 0, delayR = 30, Q0.5 is true.\n" +
//                    "[4]After I0.2 until (I0.3 or not Q0.2), delayL = 30, Q0.4 is true.\n" +
//                    "[5]When Q0.5, Q0.4 is false.\n" +
//                    "[6]When (not Q2.1 and (not Q1.3 and (I1.2 and (not Q0.6 and Q0.2)))), Q0.7 is true.\n" +
//                    "[7]When (not Q2.1 and (not Q1.3 and (I1.3 and (not Q0.7 and Q0.2)))), Q0.6 is true.\n" +
//                    "[8]When (I0.4 and (not I2.2 and (not Q1.1 and Q0.2))), Q1.0 is true.\n" +
//                    "[9]When (I0.5 and (not I2.3 and (not Q1.0 and Q0.2))), Q1.1 is true.\n" +
//                    "[10]When ((not Q2.1 or I2.0) and ((Q2.1 or Q2.0) and (not I0.6 and (not I2.4 and (not I1.3 and not I1.5))))), Q1.2 is true.\n" +
//                    "[11]When (I1.7 and Q0.2), Q1.4 is true.\n" +
//                    "[12]When Q1.2, Q1.3 is false.\n" +
//                    "[13]When Q1.5, Q1.3 is false.\n" +
//                    "[14]When Q0.6, Q1.3 is false.\n" +
//                    "[15]When Q0.7, Q1.3 is false.\n" +
//                    "[16]When (I1.7 and Q0.2), Q1.3 is true.\n" +
//                    "[17]After (I2.1 and I1.4) until (Q1.2 or (M0.0 or not Q0.2)), Q1.5 is true.\n" +
//                    "[18]After (Q2.1 or (I2.5 or I1.0)) until (not Q1.5 or not Q0.2), delayL = 10, M0.0 is true.\n" +
//                    "[19]After (Q2.1 or (I2.5 or I1.0)) until (not Q1.5 or not Q2.0), Q1.7 is true.\n" +
//                    "[20]When I2.6, Q2.1 is false.\n" +
//                    "[21]When I1.5, Q1.6 is true.\n" +
//                    "[22]When Q1.6, Q2.0 is true.";

    public static final String text2 = "[2]After (X1 and (X2 and (X3 or X4))), P is false.";
    public static final String text3 = "[3]After (X1 or (X2 and (X3 or X4))), P is true.";
    public static final String text4 = "[4]After (X1 or (X2 and (X3 or X4))), P is false.";
    public static final String text5 = "[5]After (X1 or ((X2 or X3) or X4)), P is true.";
    public static final String text6 = "[6]After I0.2 until ((I0.3 or Q0.4) or not I0.0), delayL = 0, delayR = 30, Q0.5 is true.";
    public static final String text7 = "[7]After (((A or B) and not C) or D), Q0.5 is true.";

    // Circular Dependent requirements

    public static final String c1 = "[1]When A1, A2 is true.";
    public static final String c2 = "[2]When A2, A3 is false.";
    public static final String c3 = "[3]When A3, A1 is true.";


    @Test
    public void testRequirementParser() {

        SPSFrontEnd fe = new SPSFrontEnd();
        fe.parseString(case3);
        List<Requirement> requirements = fe.getRequirements();
        assertNotNull(requirements);

        for (Requirement req: requirements) {
            System.out.println(req.getReqId() + ", " + req.key());
        }
    }

    @Test
    public void testTranslate() {
        SPSFrontEnd fe = new SPSFrontEnd();
        String text;
        text = text7;
//        text = text2 + "\n" + text3 + "\n" + text4 + "\n" + text5;
        fe.parseString(text);
        ILCode ilCode = fe.getILCode(null);

        printRequirementsAndILCodes(ilCode);
    }

    @Test
    public void testCase1() {
        SPSFrontEnd fe = new SPSFrontEnd();
        String text;
        text = case1;
        fe.parseString(text);
        ILCode ilCode = fe.getILCode(null);

        System.out.println(ilCode.getConflictedRequirements());

        List<List<String>> priorityArray = new ArrayList<List<String>>() {{
            add(new ArrayList<>(Arrays.asList("1", "4")));
            add(new ArrayList<>(Arrays.asList("3", "2")));
        }};
        ILCode ilCode1 = fe.getILCode(priorityArray);

        printRequirementsAndILCodes(ilCode1);
        System.out.println();
        System.out.println();
        System.out.println(ilCode1.getGeneratedILCode());
    }


    @Test
    public void testCase2() {
        SPSFrontEnd fe = new SPSFrontEnd();
        String text;
        text = case2;
        fe.parseString(text);
        ILCode ilCode = fe.getILCode(null);

        System.out.println(ilCode.getConflictedRequirements());

        List<List<String>> priorityArray = new ArrayList<List<String>>() {{
            add(new ArrayList<>(Arrays.asList("3", "4", "5")));
            add(new ArrayList<>(Arrays.asList("6", "7")));
        }};
        ILCode ilCode1 = fe.getILCode(priorityArray);

        printRequirementsAndILCodes(ilCode1);
        System.out.println();
        System.out.println();
        System.out.println(ilCode1.getGeneratedILCode());
    }

    @Test
    public void testCircularDependency() {
        SPSFrontEnd fe = new SPSFrontEnd();
        String text;
//        text = c1 + "\n" + c2 + "\n" + c3;
        text = case3;
        fe.parseString(text);
        ILCode ilCode = fe.getILCode(null);

        //[[3, 5], [3, 4, 5], [6, 7], [6, 7, 14], [7, 14], [6, 15], [8, 9], [17, 18]]
        //{3=[5], 14=[6, 7], 4=[3], 15=[6], 5=[3, 4], 6=[7, 15], 17=[18], 7=[6, 14], 18=[17], 8=[9], 9=[8]}
        System.out.println(ilCode.getCircularDependencyRequirements());
        System.out.println(ilCode.getCircularDependencyTable());
        System.out.println(ilCode.getConflictedRequirements());

        List<List<String>> priorityArray = new ArrayList<List<String>>() {{
            add(new ArrayList<>(Arrays.asList("4", "5")));
            add(new ArrayList<>(Arrays.asList("7", "8")));
            add(new ArrayList<>(Arrays.asList("6", "9")));
            add(new ArrayList<>(Arrays.asList("17", "19")));
            add(new ArrayList<>(Arrays.asList("11", "12")));
            add(new ArrayList<>(Arrays.asList("10", "13")));
            add(new ArrayList<>(Arrays.asList("18", "20")));
        }};

        ILCode ilCode1 = fe.getILCode(priorityArray);
        System.out.println();
        System.out.println();
        System.out.println(ilCode1.getGeneratedILCode());
    }

    private void printRequirementsAndILCodes(ILCode ilCode) {
        System.out.println();
        System.out.println("Requirements And ILCodes:");
        for (int index = 0; index < ilCode.getScopeCodes().size(); index++) {
            System.out.println("---------------------------------------------");
            System.out.println(ilCode.getRequirements().get(index));
//            System.out.println();
//            System.out.println(ilCode.getPatternScopeCodes().get(index));
            System.out.println();
            System.out.println(ilCode.getScopeCodes().get(index));
            System.out.println("---------------------------------------------");
            System.out.println();
        }
    }
}
