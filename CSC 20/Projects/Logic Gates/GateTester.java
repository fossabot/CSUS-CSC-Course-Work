package Project2;

public class GateTester {
 
    private static boolean twoGateTester(GateInputDouble gate, String expected) {
        GateOutput alias = (GateOutput)gate;
        DummyTestGate a = new DummyTestGate();
        DummyTestGate b = new DummyTestGate();
 
        if (alias.output() != (expected.charAt(3)=='T')) return false;
        gate.input1(true); gate.input2(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        gate.input1(true); gate.input2(false);
        if (alias.output() != (expected.charAt(1)=='T')) return false;
        gate.input1(false); gate.input2(true);
        if (alias.output() != (expected.charAt(2)=='T')) return false;
        gate.input1(false); gate.input2(false);
        if (alias.output() != (expected.charAt(3)=='T')) return false;
         
        gate.input1(a); gate.input2(b);
        a.set(true); b.set(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        b.set(false);
        if (alias.output() != (expected.charAt(1)=='T')) return false;
        a.set(false);
        if (alias.output() != (expected.charAt(3)=='T')) return false;
        b.set(true);
        if (alias.output() != (expected.charAt(2)=='T')) return false;
         
        gate.input1(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        gate.input1(false);b.set(false);
        if (alias.output() != (expected.charAt(3)=='T')) return false;
        
        return true;
    }
 
    private static boolean oneGateTester(GateInputSingle gate, String expected) {
        GateOutput alias = (GateOutput)gate;
        DummyTestGate a = new DummyTestGate();
 
        if (alias.output() != (expected.charAt(1)=='T')) return false;
        gate.input(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        gate.input(false);
        if (alias.output() != (expected.charAt(1)=='T')) return false;
         
        gate.input(a);
        a.set(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        a.set(false);
        if (alias.output() != (expected.charAt(1)=='T')) return false;
         
        gate.input(true);
        if (alias.output() != (expected.charAt(0)=='T')) return false;
        gate.input(false);
        if (alias.output() != (expected.charAt(1)=='T')) return false;
        
        return true;
    }
 
    public static void main(String[] args) {
        boolean pass = true;
        pass = pass && twoGateTester(new And(),"TFFF");
        pass = pass && twoGateTester(new Nand(),"FTTT");
        pass = pass && twoGateTester(new Or(),"TTTF");
        pass = pass && twoGateTester(new Nor(),"FFFT");
        pass = pass && twoGateTester(new Xor(),"FTTF");
        pass = pass && twoGateTester(new Xnor(),"TFFT");
        pass = pass && oneGateTester(new Not(),"FT");
        System.out.println(pass);
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
    public boolean output() {
        return value;
    }
}