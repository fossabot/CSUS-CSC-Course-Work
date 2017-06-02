package Project2;

public class Main {
    public static void main(String[] args) {

        boolean debug = true;

        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;

        /**
         * Test And Gate.
         */

        And g1 = new And();
        Not g2 = new Not();

        //Pass a gate and a boolean.
        g1.input1(g2); //True
        g1.input2(true); //True

        test1 = g1.output(); // Should print "true"

        //Change the gate value.
        g2.input(true); //False

        test2 = g1.output(); // Should print "false"

        //Pass two booleans.
        g1.input1(true); //True
        g1.input2(true); //True

        test3 = g1.output(); // Should print "true"

        //Test the gate.
        test(test1, test2, test3, "And", true, false, true, debug);

        /**
         * Test Nand Gate.
         */

        Nand g3 = new Nand();
        Not g4 = new Not();

        //Pass a gate and a boolean.
        g3.input1(g4); //True
        g3.input2(true); //True

        test1 = g3.output(); // Should print "false"

        //Change the gate value.
        g4.input(true); //False

        test2 = g3.output(); // Should print "true"

        //Pass two booleans.
        g3.input1(true); //True
        g3.input2(true); //True

        test3 = g3.output(); // Should print "false"

        //Test the gate.
        test(test1, test2, test3, "Nand", false, true, false, debug);

        /**
         * Test Nor Gate.
         */

        Nor g5 = new Nor();
        Not g6 = new Not();

        //Pass a gate and a boolean.
        g5.input1(g6); //True
        g5.input2(true); //True

        test1 = g5.output(); // Should print "false"

        //Change the gate value.
        g6.input(true); //False

        test2 = g5.output(); // Should print "false"

        //Pass two booleans.
        g5.input1(true); //True
        g5.input2(true); //True

        test3 = g5.output(); // Should print "false"

        //Test the gate.
        test(test1, test2, test3, "Nor", false, false, false, debug);

        /**
         * Test Not Gate.
         */

        Not g7 = new Not();
        Not g8 = new Not();

        //Pass a gate.
        g7.input(g8); //True
        test1 = g7.output(); // Should print "true"

        //Pass a boolean
        g7.input(true); //False
        test2 = g7.output(); // Should print "false"

        //Pass a changed gate value.
        g8.input(true);
        g7.input(g8); //False
        test1 = g7.output(); // Should print "false"

        //Test the gate.
        test(test1, test2, test3, "Not", true, false, false, debug);

        /**
         * Test Or Gate.
         */

        Or g9 = new Or();
        Not g10 = new Not();

        //Pass a gate and a boolean.
        g9.input1(g10); //True
        g9.input2(true); //True

        test1 = g9.output(); // Should print "true"

        //Change the gate value.
        g10.input(true); //False

        test2 = g9.output(); // Should print "true"

        //Pass two booleans.
        g9.input1(false); //False
        g9.input2(false); //False

        test3 = g9.output(); // Should print "false"

        //Test the gate.
        test(test1, test2, test3, "Or", true, true, false, debug);

        /**
         * Test Xnor Gate.
         */

        Xnor g11 = new Xnor();
        Not g12 = new Not();

        //Pass a gate and a boolean.
        g11.input1(g12); //True
        g11.input2(true); //True

        test1 = g11.output(); // Should print "true"

        //Change the gate value.
        g12.input(true); //False

        test2 = g11.output(); // Should print "false"

        //Pass two booleans.
        g11.input1(false); //False
        g11.input2(false); //False

        test3 = g11.output(); // Should print "true"

        //Test the gate.
        test(test1, test2, test3, "Xnor", true, false, true, debug);
        
        
        /**
         * Test Xnor Gate.
         */

/*
        Xnor g11 = new Xnor();
        Not g12 = new Not();

        //Pass a gate and a boolean.
        g11.input1(g12); //True
        g11.input2(true); //True

        test1 = g11.output(); // Should print "true"

        //Change the gate value.
        g12.input(true); //False

        test2 = g11.output(); // Should print "false"

        //Pass two booleans.
        g11.input1(false); //False
        g11.input2(false); //False

        test3 = g11.output(); // Should print "true"

        //Test the gate.
        test(test1, test2, test3, "Xnor", true, false, true, debug);

*/
    }

    public static void test(boolean a, boolean b, boolean c, String gate, boolean ans1, boolean ans2, boolean ans3, boolean debug) {

        if (a == ans1 && b == ans2 && c == ans3) {
            System.out.println("[PASSED] " + gate + " Gate");
        }

        else {
            System.out.println("[FAILED] " + gate + " Gate");

            if (a != ans1) {
                System.out.println("[INFO] Failed gate and boolean pass.");
                if (debug = true)
                    System.out.println("Test 1: " + a + "   Expected: " + ans1);
            }

            if (b != ans2) {
                System.out.println("[INFO] Failed gate change detection.");
                if (debug == true)
                    System.out.println("Test 2: " + b + "   Expected: " + ans2);
            }

            if (c != ans3) {
                System.out.println("[INFO] Failed boolean and boolean pass.");
                if (debug == true)
                    System.out.println("Test 3: " + c + "   Expected: " + ans3);
            }
        }
    }
}
