package Project4;

/**The Buffer class determines holds a boolean or 
 * gate value to be referenced later.
 *
 * @author Marc Woodyard
 * @version April 25 2017
 */
public class Buffer implements GateOutput, GateInputSingle {
    private boolean    result     = false;
    private GateOutput gate;
    private boolean    gatePassed = false;

    /**
     * Takes the output from a gate as a parameter
     * and sets that value as in input.
     * @param The output from a logic gate.
     * @return None
     */
    @Override
    public void input(GateOutput gate) {
        this.gate = gate;
        this.result = gate.output();
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
        this.gatePassed = false;
        this.result = value;
    }

    /**
     * Returns the value of the gate.
     * @param None
     * @return Logic gate's boolean value. 
     */
    @Override
    public boolean output() {
        //Check if gate changed.
        if (this.gatePassed == true)
            this.result = this.gate.output();

        return result;
    }
}
