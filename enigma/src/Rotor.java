public class Rotor {
    private String state;
    private int pointer;
    private boolean should_spin = true; //The fourth rotor didn't rotate or wasn't used - TODO: double check this (<-)
    private String[] state_values = new
            String[]{
            "A","B","C","D","E",
            "F","G","H","I","J",
            "K","L","M","N","O",
            "P","Q","R","S","T",
            "U","V","W","X","Y","Z"
    };

    /**
     *  A rotor of the enigma machine. Set the state, as it encrypts a letter, it will rotate.
     */
    Rotor(){
        setState("A");
    }
    Rotor(boolean rotatable){
        setState("A");
        this.should_spin = rotatable;
    }

    /**
     *  Set the current state of the rotor. This should be an ASCII value from 65 to 90, inclusive.
     *
     *  Set the state, and then make sure the pointer is correct.
     *
     * @param s - the desired state of the rotor
     */
    public void setState(String s){
        //Side effect alert!
        //Change the pointer too!
        this.state = s;
        setPointer();
    }

    /**
     *  Set the pointer to the current state in the values array.
     *
     *  Find the state, and set pointer to that index.
     */
    void setPointer() {
        for(int i = 0; i < state_values.length; i++){
            if(state_values[i].equals(this.state)){
                this.pointer = i;
                break;
            }
        }
    }

    /**
     *  Sets the array to be used for the values of the rotor. Should be an array of single character strings,
     *   using the ASCII values from 65 to 90 inclusive.
     * @param v - The array that will replace the current values array.
     */
    void setStateValues(String[] v){
        //Assuming that each is one character long.
        if(v.length == 26){
            this.state_values = v;
        }
    }

    /**
     *  'Spins' the rotor.
     *
     *  Move the pointer and renew the state.
     *
     *  setState has a side affect for pointer.
     */
    void rotate(){
        if(should_spin) {
            //Mod here since the rotors are circular
            this.pointer = (this.pointer + 1) % state_values.length;
            this.setState(state_values[this.pointer]);
        }
    }

    /**
     *  Converts the character. Also rotates the rotor.
     *
     * @param c - character to convert
     * @return - converted character
     */
    String convertCharacter(String c){
        rotate();
        return "TODO";
    }

    @Override
    public String toString(){
        return this.state;
    }
}
