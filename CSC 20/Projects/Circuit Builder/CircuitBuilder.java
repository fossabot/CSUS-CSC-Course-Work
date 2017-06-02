package Project4;

/**
 * The CircuitBuilder class simulates
 * logic gates.
 *
 * @author Marc Woodyard
 * @version May 3 2017
 */

import java.util.Map;
import java.util.Stack;

public class CircuitBuilder {
    /**
     * Converts a string passeed as a parameter
     * to postfix notation.
     * 
     * @param String - Accepts a string in infix notation.
     * @return String - Returns a string in postfix notation.
     */
    public static String toPostfix(String infix) {
        String result = "";
        Stack<String> ops = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {

            char current = infix.charAt(i);

            //Rule #4
            if (ops.empty() == true && current == '*' | current == '+' | current == '-') {
                ops.push(Character.toString(current));
            }

            //Rule #4.5
            else if (current == '*' | current == '+' | current == '-' && ops.peek().equals("("))
                ops.push(Character.toString(current));

            //Rule #5
            else if (current == '*' | current == '+' | current == '-' & ops.empty() == false
                     && precedence(Character.toString(current)) >= precedence(ops.peek())) {
                ops.push(Character.toString(current));
            }

            //Rule #6
            else if (current == '*' | current == '+' | current == '-' & ops.empty() == false
                     && precedence(Character.toString(current)) < precedence(ops.peek())) {
                while (ops.empty() == false && precedence(Character.toString(current)) < precedence(ops.peek())) {
                    result = result + ops.pop();
                }
                ops.push(Character.toString(current));
            }

            //Rule #2
            else if (current == '(')
                ops.push(Character.toString(current));

            //Rule #3
            else if (current == ')') {
                while (ops.peek().equals("(") == false) {
                    result = result + ops.pop();
                }
                if (ops.peek().equals("("))
                    ops.pop(); //Disregard element.
            }

            //Rule #1
            else
                result = result + Character.toString(current);
        }

        //Rule #7
        while (ops.empty() == false) {
            if (ops.peek().equals("(") | ops.peek().equals(")"))
                ops.pop(); //Disregard element.
            else
                result = result + ops.pop();
        }

        return result;

        /**
         * Shunting Yard Algorithm:
         * http://www.oxfordmathcenter.com/drupal7/node/628
         */

    }

    /**
     * Builds a circuit simulation.
     * 
     * @param String - Accepts a string in postfix notation.
     * @param Map - Accepts a empty map to store postfix elements and GateInputSingle elements.
     * @return GateOutput - Reference to GateOutput.
     */
    public static GateOutput buildCircuit(String postfix, Map<String, GateInputSingle> variables) {

        Stack<GateOutput> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {

            Not not = new Not();
            And and = new And();
            Or or = new Or();

            Buffer buffer = new Buffer();

            char cur = postfix.charAt(i);

            //Not
            if (cur == '-') {
                not.input((GateOutput)stack.pop());
                stack.push(not);
            }

            //And
            else if (cur == '*') {
                and.input1((GateOutput)stack.pop());
                and.input2((GateOutput)stack.pop());
                stack.push(and);
            }

            //Or
            else if (cur == '+') {
                or.input1((GateOutput)stack.pop());
                or.input2((GateOutput)stack.pop());
                stack.push(or);
            }

            //True Character
            else if (cur == 'T') {
                buffer.input(true);
                stack.push(buffer);
            }

            //False Character
            else if (cur == 'F') {
                buffer.input(false);
                stack.push(buffer);
            }

            //Variable
            else {
                if (variables.get(Character.toString(cur)) == null)
                    variables.put(Character.toString(cur), new Buffer());

                stack.push((GateOutput)variables.get(Character.toString(cur)));
            }
        }

        return stack.pop();

    }

    /**
     * Returns the precedence for logical operators.
     * @params String - operator.
     * @returns int - returns precedence level.
     */
    private static int precedence(String x) {
        switch (x) {
            case "-":
                return 3;
            case "*":
                return 2;
            case "+":
                return 1;
        }
        return 0;
    }

}
