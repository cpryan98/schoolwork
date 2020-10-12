import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.function.Predicate;

public class HW7TestDrv {

public static void main(String[] args) throws Throwable {
    LicensePlate lp1 = new LicensePlate();

    // --- isPlateTaken ---------------------------------------------------------------------------------
    try {
        String candidatePlate = "4SURE";
        boolean expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "AAC-5367";
        expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "000 LALA";
        expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "HELLO";
        expectedResult = false;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "JOB-0704";
        expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "JOB-0705";
        expectedResult = false;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "LEDZEPP";
        expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "ZEPLIN";
        expectedResult = false;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "ZZZ-9474";
        expectedResult = true;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "ZZZ-9475";
        expectedResult = false;
        doTest(lp1, "isPlateTaken", new Object[]{candidatePlate}, expectedResult, "");

    } catch (Throwable tt) {
        printCachedMessages();
        throw tt;
    }

    printResults();

    // --- personalize ---------------------------------------------------------------------------------
    try {
        String candidatePlate = "ABBA FAN";
        boolean expectedResult = true;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "SERIOUS ABBA FAN";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "too long");

        candidatePlate = "B BUNNY";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "taken");

        candidatePlate = "RABBIT";
        expectedResult = true;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "B47M4N";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "taken");

        candidatePlate = "DOT.DOT";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "uses illegal character");

        candidatePlate = "DARTH V";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "taken");

        candidatePlate = "PUREGOLD";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "too long");

        candidatePlate = "PURGOLD";
        expectedResult = true;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "ZZZZZZZ";
        expectedResult = true;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "");

        candidatePlate = "GRB-2630";
        expectedResult = false;
        doTest(lp1, "personalize", new Object[]{candidatePlate}, expectedResult, "taken");

    } catch (Throwable tt) {
        printCachedMessages();
        throw tt;
    }

    printResults();

    // --- equals ---------------------------------------------------------------------------------
    try {
        LicensePlate lp2 = new LicensePlate();

        beginTesting("equals", 1);

        comment("comparing licenses \"AAA-AAA\" and \"AAA-AAA\"");
        lp1.personalize("AAA-AAA");
        lp2.personalize("AAA-AAA");
        boolean expectedResult = true;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"AAA-AAA\" and \"AAA AAA\"");
        lp2.personalize("AAA AAA");
        expectedResult = false;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"BOOYAHH\" and \"BOOYAHH\"");
        lp1.personalize("BOOYAHH");
        lp2.personalize("BOOYAHH");
        expectedResult = true;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"BOOYAHH\" and \"BOO YAH\"");
        lp2.personalize("BOO YAH");
        expectedResult = false;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"TTT-3456\" and \"TTT-3456\"");
        lp1.personalize("TTT-3456");
        lp2.personalize("TTT-3456");
        expectedResult = true;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"TTT-3456\" and \"BOOYAHH\"");
        lp2.personalize("BOOYAHH");
        expectedResult = false;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

        comment("comparing licenses \"TTT-3456\" and \"TTT-3457\"");
        lp2.personalize("TTT-3457");
        expectedResult = false;
        doTest(lp1, "equals", new Object[]{lp2}, expectedResult, "");

    } catch (Throwable tt) {
        printCachedMessages();
        throw tt;
    }

    printResults();

    // --- compareTo ---------------------------------------------------------------------------------
    try {
        beginTesting("compareTo");

        HW7TestDrv myDrv = new HW7TestDrv();

        LicensePlate lp2 = new LicensePlate();

        lp1.personalize("AAA-0001");
        lp2.personalize("AAA-0002");
        int expectedResult = -1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("AAA-0001");
        expectedResult = 0;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("AAA-0000");
        expectedResult = 1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp1.personalize("LARRY");
        lp2.personalize("MOE");
        expectedResult = -1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("LARRY");
        expectedResult = 0;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("CURLY");
        expectedResult = 1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("LARRYS");
        expectedResult = -1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp1.personalize("TTT-3454");
        lp2.personalize("TTT-3455");
        expectedResult = -1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("TTT-3454");
        expectedResult = 0;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

        lp2.personalize("TTT-3453");
        expectedResult = 1;
        doTest(myDrv, "compareToWrapper", new Object[]{lp1,lp2}, expectedResult, "");

    } catch (Throwable tt) {
        printCachedMessages();
        throw tt;
    }

    printResults();

    // --- all methods --------------------------------------------------------------------------
    printSummary();
}

public int compareToWrapper(LicensePlate lp1, LicensePlate lp2) {
    int result = lp1.compareTo(lp2);
    if (result != 0) {
        result /= Math.abs(result);
    }
    return result;
}


    private static final String MSG_PASS_TRUE  = "      ";
    private static final String MSG_PASS_FALSE = "FAIL: ";
    private static final String COMMENT_PREFIX = "      // ";

    private static class Tt {
        private boolean didPass = false;

        protected void setPassed(boolean passed) {
            didPass = passed;
            if (didPass) {
                msgPass = MSG_PASS_TRUE;
            } else {
                msgPass = MSG_PASS_FALSE;
            }
        }

        protected boolean passed() { return didPass; }

        private boolean isComment = false;


        protected boolean threwException = false;
        protected String msgPass = MSG_PASS_FALSE;
        protected String msgCall = "";
        protected String msgReturn = "";
        protected Object returnedObject;
    }

    private static List<Tt> cachedComments = new ArrayList<Tt>();
    private static Map<String, List<Tt>> testMap = new LinkedHashMap<>();

    private final static Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>();

    static {
        primitiveMap.put(Boolean.class, boolean.class);
        primitiveMap.put(Byte.class, byte.class);
        primitiveMap.put(Short.class, short.class);
        primitiveMap.put(Character.class, char.class);
        primitiveMap.put(Integer.class, int.class);
        primitiveMap.put(Long.class, long.class);
        primitiveMap.put(Float.class, float.class);
        primitiveMap.put(Double.class, double.class);
    }

    private static String currentTestSequenceName = null;
    private static int outLines = 3;

    public static void beginTesting(String testSequenceName) {
        beginTesting(testSequenceName, 3);
    }

    public static void beginTesting(String testSequenceName, int linesBetweenSpacesInOutput) {
        currentTestSequenceName = testSequenceName;
        outLines = linesBetweenSpacesInOutput;
        addLabelToMap(testSequenceName);
    }

    public static void finishTesting() {
        currentTestSequenceName = null;
    }

    /**
        We invoke the method with name methodName on the srv object with the parameters found in params.

        For explanatory purposes, the call would look like this:

            actualResult = srv.methodName(params[0], params[1], ...);

        The expectedResult is then compared to the actual result.

        msgOnFail will be appended to the test's line of output if the test fails.  It could contain a useful diagnostic
            message to the method writer pointing out the reason for failure.
    */
    public static Tt doTest(Object srv,
                              String methodName,
                              Object[] params,
                              Object expectedResult,
                              String msgOnFail) {

        Predicate<Object> equalsExpected = obj -> {
            return wrappedObjsAreEqual(obj, expectedResult);
        };
        Tt test = doTest(srv, methodName, params, equalsExpected, msgOnFail);
        if (test != null && !test.passed()) {
            if (!test.threwException) {
                if (msgOnFail == null || msgOnFail.length() == 0) {
                    test.msgReturn += " (expected " + wrappedObjToString(expectedResult) + ")";
                } else {
                    int failMsgIdx = test.msgReturn.lastIndexOf(msgOnFail);
                    test.msgReturn = test.msgReturn.substring(0, failMsgIdx)
                                   + "expected " + wrappedObjToString(expectedResult)
                                   + " ("
                                   + test.msgReturn.substring(failMsgIdx)
                                   + "))";
                }
            }
        }
        return test;
    }

    /**
        We invoke the method with name methodName on the srv object with the parameters found in params.

        For explanatory purposes, the call would look like this:

            actualResult = srv.methodName(params[0], params[1], ...);

        The result is then tested using the tester Predicate.

        msgOnFail will be appended to the test's line of output if the test fails.  It could contain a useful diagnostic
            message to the method writer pointing out the reason for failure.
    */
    public static Tt doTest(Object srv,
                              String methodName,
                              Object[] params,
                              Predicate<Object> tester,
                              String msgOnFail) {

        if (currentTestSequenceName == null || currentTestSequenceName.length() == 0) {
            beginTesting(methodName);
        }

        Class<?> classSrv = srv.getClass();

        Class<?>[] paramClasses = new Class<?>[params.length];
        for (int ii = 0; ii < params.length; ii++) {
            paramClasses[ii] = params[ii].getClass();
            if (primitiveMap.containsKey(paramClasses[ii])) {
                paramClasses[ii] = primitiveMap.get(paramClasses[ii]);
            }
        }

        Tt out = new Tt();

        if (params.length == 0) {
            out.msgCall = methodName + "()";
        } else {
            out.msgCall = methodName + "(";
            for (int ii = 0; ii < params.length; ii++) {
                Object param = params[ii];
                out.msgCall += wrappedObjToString(param);
                if (ii < params.length - 1) {
                    out.msgCall += ", ";
                } else {
                    out.msgCall += ")";
                }
            }
        }

        Method method = null;
        try {
            method = classSrv.getMethod(methodName, paramClasses);
            out.returnedObject = method.invoke(srv, params);
        } catch(NoSuchMethodException exc) {
            out.threwException = true;
            out.msgReturn = "--> ERROR: method <" + methodName + "> either doesn't exist or doesn't take the parameter or param types provided.";
            addTestToMap(currentTestSequenceName, out);
            return out;
        } catch(InvocationTargetException exc) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exc.getCause().printStackTrace(pw);

            out.threwException = true;
            out.msgReturn = "--> (Exception shown below)\n" + sw.toString();
            out.msgReturn = out.msgReturn.replaceAll("(?m)^", "      ");
            addTestToMap(currentTestSequenceName, out);
            return out;
        } catch(Exception exc) {
            System.err.println("ERROR: Unwrapped Exception during invocation.");
            exc.printStackTrace();
        }

        out.msgReturn = "--> ";
        out.msgReturn += wrappedObjToString(out.returnedObject);

        if (tester.test(out.returnedObject)) {
            out.setPassed(true);
        } else {
            // out.msgReturn += " (expected " + wrappedObjToString(expectedResult);
            if (msgOnFail != null && msgOnFail.length() > 0) {
                out.msgReturn += " (" + msgOnFail + ")";
            }
        }
        addTestToMap(currentTestSequenceName, out);
        return out;
    }

    public static Tt comment(String comment) {
        Tt out = new Tt();
        out.isComment = true;
        out.msgCall = COMMENT_PREFIX + comment;
        addCommentToMap(out);
        return out;
    }

    public static void printCachedMessages() {
        System.out.println(rightPad("----- cached messages for <" + currentTestSequenceName + "> ", "-", 80) + "\n");
        printMsgs(currentTestSequenceName, true);
    }

    public static void printMsgs(String testSequenceName, boolean supressMsgIfAllTestsSame) {
        if (!testMap.containsKey(testSequenceName)) {
            System.err.println("Test array not created for  <" + testSequenceName + ">.");
            return;
        }
        List<Tt> arr = testMap.get(testSequenceName);
        if (arr.isEmpty()) {
            System.err.println("No <" + testSequenceName + "> tests have been run.");
            return;
        }

        String delimiterLeft = "<";
        String delimiterRight = ">";

        if (arr.get(0).returnedObject instanceof String) {
            delimiterLeft = "\"";
            delimiterRight = "\"";
        } else if (arr.get(0).returnedObject instanceof Character) {
            delimiterLeft = "'";
            delimiterRight = "'";
        }

        if (!allTestsThrewExceptions(testSequenceName) && allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName) && !supressMsgIfAllTestsSame) {
            System.out.println("   ==> <" + testSequenceName + "> not implemented: returns " + delimiterLeft + wrappedObjToString(arr.get(0).returnedObject)
                                + delimiterRight + " for all tests.\n");
        } else {
            int lenMsgCallMax = 0;
            for (Tt out : arr) {
                if (!out.isComment) {
                    int lenMsgCall = out.msgCall.length();
                    if (lenMsgCall > lenMsgCallMax) lenMsgCallMax = lenMsgCall;
                }
            }
            int spacer = 0;
            for (int ii = 0; ii < arr.size(); ii++) {
                Tt out = arr.get(ii);
                if (out.isComment) {
                    System.out.println(out.msgCall);
                } else {
                    System.out.println(out.msgPass + rightPad(out.msgCall, " ", lenMsgCallMax) + " " + out.msgReturn);
                    spacer++;
                    if (spacer%outLines == 0 && ii < arr.size() - 1) {
                        System.out.println();
                        spacer = 0;
                    }
                }
            }
        }
    }

    public static void printResults(boolean supressMsgIfAllTestsSame) {
        System.out.println(rightPad("----- <" + currentTestSequenceName + "> ", "-", 80) + "\n");
        printMsgs(currentTestSequenceName, supressMsgIfAllTestsSame);
        printTestSequenceSummary(currentTestSequenceName);
        finishTesting();
    }

    public static void printResults() {
        printResults(false);
    }

    public static void printTestSequenceSummary(String testSequenceName) {
        if (!testMap.containsKey(testSequenceName)) {
            System.err.println("ERROR in test file: call to printTestSequenceSummary for test <" + testSequenceName + ">, but no calls to doTest for it.");
            return;
        }

        List<Tt> arr = testMap.get(testSequenceName);
        if (arr.isEmpty()) {
            System.out.println("   ==> No <" + testSequenceName + "> tests were performed. Is the appropriate method present and named correctly in your server?\n");
            return;
        }
        if (allTestsThrewExceptions(testSequenceName) || !allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName)) {
            int testsFailed = countTestsFailed(testSequenceName);
            if (testsFailed == 0) {
                System.out.println("\n   ==> All <" + testSequenceName + "> tests passed!\n");
            } else if (testsFailed == 1) {
                System.out.println("\n   ==> All <" + testSequenceName + "> tests passed except one- getting close!\n");
            } else {
                System.out.println("\n   ==> The <" + testSequenceName + "> tests failed " + testsFailed + " tests. More work to do...\n");
            }
        }
    }

    public static void printSummary() {
        String out = "";
        for (String testSequenceName : testMap.keySet()) {
            List<Tt> arr = testMap.get(testSequenceName);
            if (arr.isEmpty()) {
                if (out.length() > 0) { out += "\n"; }
                out += "    |  No <" + testSequenceName + "> tests were performed.";
            } else if (allReturnedObjsAreEqualAndSomeFailsPresent(testSequenceName) && !allTestsThrewExceptions(testSequenceName)) {
                if (out.length() > 0) { out += "\n"; }
                String delimiterLeft = "<";
                String delimiterRight = ">";

                if (arr.get(0).returnedObject instanceof String) {
                    delimiterLeft = "\"";
                    delimiterRight = "\"";
                } else if (arr.get(0).returnedObject instanceof Character) {
                    delimiterLeft = "'";
                    delimiterRight = "'";
                }

                out += "    |  <" + testSequenceName + "> not implemented: returns " + delimiterLeft + wrappedObjToString(arr.get(0).returnedObject)
                                    + delimiterRight + " for all tests.";
            } else  {
                int fails = countTestsFailed(testSequenceName);
                if (fails > 0) {
                    if (out.length() > 0) { out += "\n"; }
                    out += "    |  <" + testSequenceName + "> failed " + fails + " test" + (fails > 1 ? "s" : "") + ".";
                }
                int excsThrown = countThrownExceptions(testSequenceName);
                if (excsThrown > 0) {
                    if (out.length() > 0) { out += "\n"; }
                    out += "    |      (<" + testSequenceName + "> threw Exception for " + excsThrown + " test" + (excsThrown > 1 ? "s" : "") + ".)";
                }
            }
        }
        if (out.length() == 0) {
            System.out.println("    +--------------------------------------+");
            System.out.println("    |    -All methods pass all tests!-     |");
            System.out.println("    +--------------------------------------+\n");
        } else {
            System.out.println(rightPad("    +", "-", 80));
            System.out.println(out);
            System.out.println(rightPad("    +", "-", 80) + "\n");
        }
    }

    public static void reset() {
        testMap = new LinkedHashMap<String, List<Tt>>();
    }

    private static String wrappedObjToString(Object obj) {
        if (obj == null) {
            return "null";
        }

        if (!isArray(obj)) {
            return obj.toString();
        }
        Class<?> cc = obj.getClass();
        if (!cc.getComponentType().isPrimitive()) {
            cc = Object[].class;
        }

        String out = "";
        try {
            Method mm = Arrays.class.getMethod("toString", cc);
            out = (String)mm.invoke(null, obj);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
        return out;
    }

    private static boolean wrappedObjsAreEqual(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null) { return false; }
        return Arrays.deepEquals(new Object[] { obj1 }, new Object[] { obj2 });
    }

    private static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray());
    }

    private static String rightPad(String in, String ss, int totalLen) {
        while (in.length() < totalLen)
            in += ss;
        return in;
    }

    private static void addLabelToMap(String testSequenceName) {
        if (!testMap.containsKey(testSequenceName)) {
            List<Tt> arr = new ArrayList<>();
            testMap.put(testSequenceName, arr);
            addCachedCommentsToMap(testSequenceName);
        }
    }

    private static void addCommentToMap(Tt comment) {
        if (currentTestSequenceName == null || currentTestSequenceName.length() == 0) {
            cachedComments.add(comment);
        } else {
            List<Tt> arr = testMap.get(currentTestSequenceName);
            arr.add(comment);
        }
    }

    private static void addCachedCommentsToMap(String testSequenceName) {
        if (!testMap.containsKey(testSequenceName)) {
            addLabelToMap(testSequenceName);
        }
        List<Tt> arr = testMap.get(testSequenceName);
        arr.addAll(cachedComments);
        cachedComments.clear();
    }

    private static void addTestToMap(String testSequenceName, Tt test) {
        if (!testMap.containsKey(testSequenceName)) {
            addLabelToMap(testSequenceName);
        }
        List<Tt> arr = testMap.get(testSequenceName);
        arr.add(test);
    }

    private static int countThrownExceptions(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        int excsThrown = 0;
        for (Tt test : arr) {
            if (test.threwException) {
                excsThrown++;
            }
        }
        return excsThrown;
    }

    private static boolean allTestsThrewExceptions(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        boolean allThrew = true;
        for (Tt test : arr) {
            if (!test.isComment && !test.threwException) {
                allThrew = false;
            }
        }
        return allThrew;
    }

    private static int countTestsFailed(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        int testsFailed = 0;
        for (Tt test : arr) {
            if (!test.isComment && !test.passed()) {
                testsFailed++;
            }
        }
        return testsFailed;
    }

    private static boolean allReturnedObjsAreEqualAndSomeFailsPresent(String testSequenceName) {
        List<Tt> arr = testMap.get(testSequenceName);
        Object returnedObjPrev = null;
        boolean allReturnedObjsAreEqual = true;
        boolean someFailsPresent = false;
        for (Tt test : arr) {
            if (!test.isComment) {
                if (!test.passed()) {
                    someFailsPresent = true;
                }
                if (returnedObjPrev != null) {
                    if (!wrappedObjsAreEqual(test.returnedObject, returnedObjPrev)) {
                        allReturnedObjsAreEqual = false;
                    }
                }
                returnedObjPrev = test.returnedObject;
            }
        }
        return allReturnedObjsAreEqual && someFailsPresent;
    }
}