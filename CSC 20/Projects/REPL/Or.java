package Project4;

/**The "OR" class determines if two inputs are true
 *or false through the use of two boolean values which 
 *simulate the "OR" logic gate.
 *
 * @author Marc Woodyard
 * @version April 16 2017
 */
public class Or implements GateOutput, GateInputDouble {
    private boolean    input1      = false;
    private boolean    input2      = false;
    private GateOutput gate1;
    private GateOutput gate2;
    private boolean    gate1Passed = false;
    private boolean    gate2Passed = false;

    /**
     * Takes the output from a logic gate as a parameter
     * and sets that value as in input.
     * @param The output from a logic gate.
     * @return None
     */
    @Override
    public void input1(GateOutput gate) {
        //Save refference to the gate.
        this.gate1 = gate;
        //Set input 1 value.
        this.input1 = gate.output();
        //Set flag - gate passed.
        this.gate1Passed = true;
    }

    /**
     * Takes a boolean value as a parameter
     * and sets that value to input one.
     * @param Boolean Value.
     * @return None
     */
    @Override
    public void input1(boolean value) {
        //Set input 1 value.
        this.input1 = value;
        //Set flag - boolean passed.
        this.gate1Passed = false;
    }

    /**
     * Takes the output from a logic gate as a parameter
     * and sets that value as an input.
     * @param The output from a logic gate.
     * @return None
     */
    @Override
    public void input2(GateOutput gate) {
        //Save refference to the gate.
        this.gate2 = gate;
        //Set input 1 value.
        this.input2 = gate.output();
        //Set flag - gate passed.
        this.gate2Passed = true;
    }

    /**
     * Takes a boolean value as a parameter
     * and sets that value to input one.
     * @param Boolean Value.
     * @return None
     */
    @Override
    public void input2(boolean value) {
        //Set input 1 value.
        this.input2 = value;
        //Set flag - boolean passed.
        this.gate2Passed = false;
    }

    /**
     * Returns the value of the logic gate.
     * @param None
     * @return Logic gate's boolean value. 
     */
    @Override
    public boolean output() {
        //Check if gate1 changed.
        if (this.gate1Passed == true)
            this.input1 = this.gate1.output();

        //Cheeck if gate2 changed.
        if (this.gate2Passed == true)
            this.input2 = this.gate2.output();

        //Decide the result, then output.
        if (this.input1 == false && this.input2 == false)
            return false;
        return true;
    }
}