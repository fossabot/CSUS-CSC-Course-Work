package Project4;

/**The "NOT" class determines if one input is true
 *or false through the use of a boolean value which 
 *simulate the "NOT" logic gate.
 *
 * @author Marc Woodyard
 * @version April 16 2017
 */
public class Not implements GateOutput, GateInputSingle {
    private boolean    input      = false;
    private GateOutput gate;
    private boolean    gatePassed = false;

    /**
     * Takes the output from a logic gate as a parameter
     * and sets that value as in input.
     * @param The output from a logic gate.
     * @return None
     */
    @Override
    public void input(GateOutput gate) {
        //Save refference to the gate.
        this.gate = gate;
        //Set input 1 value.
        this.input = gate.output();
        //Set flag - gate passed.
        this.gatePassed = true;
    }

    /**
     * Takes a boolean value as a parameter
     * and sets that value to input one.
     * @param Boolean Value.
     * @return None
     */
    @Override
    public void input(boolean value) {
        //Set input 1 value.
        this.input = value;
        //Set flag - boolean passed.
        this.gatePassed = false;
    }

    
    /**
     * Returns the value of the logic gate.
     * @param None
     * @return Logic gate's boolean value. 
     */
    @Override
    public boolean output() {
        //Check if gate1 changed.
        if (this.gatePassed == true)
            this.input = this.gate.output();

        //Decide the output, then return it.
        if (this.input == true)
            return false;
        return true;
    }
}