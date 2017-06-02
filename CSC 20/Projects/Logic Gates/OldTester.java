public class GateTester {

    private static boolean twoGateTester(GateInputDouble gate, String expected) {
        GateOutput alias = (GateOutput)gate;
        DummyTestGate a = new DummyTestGate();
        DummyTestGate b = new DummyTestGate();

        if (alias.output() != (expected.charAt(3) == 'T')) {
            System.out.println("Error: Line 1");
            System.exit(0);
        }

        gate.input1(true);
        gate.input2(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 2");
            System.exit(0);
        }

        gate.input1(true);
        gate.input2(false);

        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 3");
            System.exit(0);
        }

        gate.input1(false);
        gate.input2(true);

        if (alias.output() != (expected.charAt(2) == 'T')) {
            System.out.println("Error: Line 4");
            System.exit(0);
        }

        gate.input1(false);
        gate.input2(false);

        if (alias.output() != (expected.charAt(3) == 'T')) {
            System.out.println("Error: Line 5");
            System.exit(0);
        }

        gate.input1(a);
        gate.input2(b);

        a.set(true);
        b.set(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 6");
            System.exit(0);
        }

        b.set(false);

        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 7");
            System.exit(0);
        }

        a.set(false);

        if (alias.output() != (expected.charAt(3) == 'T')) {
            System.out.println("Error: Line 8");
            System.exit(0);
        }

        b.set(true);

        if (alias.output() != (expected.charAt(2) == 'T')) {
            System.out.println("Error: Line 9");
            System.exit(0);
        }

        gate.input1(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 10");
            System.exit(0);
        }

        gate.input1(false);

        b.set(false);

        if (alias.output() != (expected.charAt(3) == 'T')) {
            System.out.println("Error: Line 11");
            System.exit(0);
        }

        return true;
    }

    private static boolean oneGateTester(GateInputSingle gate, String expected) {

        GateOutput alias = (GateOutput)gate;
        DummyTestGate a = new DummyTestGate();

        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 12");
            System.exit(0);
        }

        gate.input(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 13");
            System.exit(0);
        }

        gate.input(false);
        
        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 14");
            System.exit(0);
        }

        gate.input(a);

        a.set(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 15");
            System.exit(0);
        }

        a.set(false);

        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 16");
            System.exit(0);
        }

        gate.input(true);

        if (alias.output() != (expected.charAt(0) == 'T')) {
            System.out.println("Error: Line 17");
            System.exit(0);
        }

        gate.input(false);

        if (alias.output() != (expected.charAt(1) == 'T')) {
            System.out.println("Error: Line 18");
            System.exit(0);
        }

        return true;
    }

    public static void main(String[] args) {
        boolean pass = true;
        pass = pass && twoGateTester(new And(), "TFFF");
        System.out.println("[Passed] AND Gate");
        pass = pass && twoGateTester(new Nand(), "FTTT");
        System.out.println("[Passed] NAND Gate");
        pass = pass && twoGateTester(new Or(), "TTTF");
        System.out.println("[Passed] OR Gate");
        pass = pass && twoGateTester(new Nor(), "FFFT");
        System.out.println("[Passed] NOR Gate");
        pass = pass && twoGateTester(new Xor(), "FTTF");
        System.out.println("[Passed] XOR Gate");
        pass = pass && twoGateTester(new Xnor(), "TFFT");
        System.out.println("[Passed] XNOR Gate");
        pass = pass && oneGateTester(new Not(), "FT");
        System.out.println("[Passed] NOT Gate");

        if(pass == true) {
            System.out.println("YOU DID IT!!!!!! YAHHHHHHH!!!!");
            System.out.println("\nNow download a clean tester to make sure everything work properly");
        }  
    }
}

/* By adding a non-public class here, it can be used by any class in the
 * same "package" including GateTester. This class isn't really a gate,
 * but is used for testing.
 */

class DummyTestGate implements GateOutput {
    private boolean value;

    public void set(boolean value) {
        this.value = value;
    }

    @Override
    public boolean output() {
        return value;
    }
}
