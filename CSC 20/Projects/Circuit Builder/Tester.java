package Project4;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("unchecked")

public class Tester {
    public static void main(String[] paramArrayOfString) {
        try {
            boolean pass = true;
            pass = pass && CircuitBuilder.toPostfix("A").equals("A");
            pass = pass && CircuitBuilder.toPostfix("A+B").equals("AB+");
            pass = pass && CircuitBuilder.toPostfix("A+B*C").equals("ABC*+");
            pass = pass && CircuitBuilder.toPostfix("A*B+C").equals("AB*C+");
            pass = pass && CircuitBuilder.toPostfix("A*(B+C)").equals("ABC+*");
            pass = pass && CircuitBuilder.toPostfix("A*-(B+C)").equals("ABC+-*");
            pass = pass && CircuitBuilder.toPostfix("(--((-A+--B)*-(--C+-D)))").equals("A-B--+C--D-+-*--");
            System.out.println("toPostfix: " + pass);
        } catch (Exception e) {
            System.out.println("toPostfix: false");
        }
        
                try {
            boolean pass = true;
            /* Test: A */
            Map<String,GateInputSingle> vars = new HashMap<>();
            GateOutput out = CircuitBuilder.buildCircuit("A", vars);
            pass = pass && (out.output()==false);
            vars.get("A").input(true);
            pass = pass && (out.output()==true);
             
            /* Test: TF+ */
            vars.clear();
            out = CircuitBuilder.buildCircuit("TF+", vars);
            pass = pass && (out.output()==true);
             
            /* Test: A-A* */
            vars.clear();
            out = CircuitBuilder.buildCircuit("A-A*", vars);
            pass = pass && (out.output()==false);
            vars.get("A").input(true);
            pass = pass && (out.output()==false);
             
            /* Test: ABC+-* */
            vars.clear();
            out = CircuitBuilder.buildCircuit("ABC+-*", vars);
            pass = pass && (out.output()==false);
            vars.get("C").input(true);
            pass = pass && (out.output()==false);
            vars.get("B").input(true);
            pass = pass && (out.output()==false);
            vars.get("C").input(false);
            pass = pass && (out.output()==false);
            vars.get("A").input(true);
            pass = pass && (out.output()==false);
            vars.get("C").input(true);
            pass = pass && (out.output()==false);
            vars.get("B").input(false);
            pass = pass && (out.output()==false);
            vars.get("C").input(false);
            pass = pass && (out.output()==true);
 
            /* Test: A--B--C--+--*-- */
            vars.clear();
            out = CircuitBuilder.buildCircuit("ABC--+--*--", vars);
            pass = pass && (out.output()==false);
            vars.get("C").input(true);
            pass = pass && (out.output()==false);
            vars.get("B").input(true);
            pass = pass && (out.output()==false);
            vars.get("C").input(false);
            pass = pass && (out.output()==false);
            vars.get("A").input(true);
            pass = pass && (out.output()==true);
            vars.get("C").input(true);
            pass = pass && (out.output()==true);
            vars.get("B").input(false);
            pass = pass && (out.output()==true);
            vars.get("C").input(false);
            pass = pass && (out.output()==false);
 
            System.out.println("buildCircuit: " + pass);
        }
        catch(Exception e) {
            System.out.println("buildCircuit: false");
        }
    }
}
