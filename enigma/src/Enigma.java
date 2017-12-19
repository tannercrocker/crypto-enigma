public class Enigma {
    Rotor[] rotors = new Rotor[4];
    Plugboard plugboard;

    /**
     *  An emulation of the enigma machine used by German (and possibly other Axis powers) in WWII.
     *
     */
    Enigma(){
        this.rotors[0] = new Rotor();
        this.rotors[1] = new Rotor();
        this.rotors[2] = new Rotor();
        this.rotors[3] = new Rotor();

        this.plugboard = new Plugboard();

        this.configureRotors();
        this.configurePlugboard();
    }

    /**
     *  Changes the letters of a message, so that the original message should be unobtainable.
     * @param msg - the message to be encrypted
     * @return - the encrypted message
     */
    public String encryptMessage(String msg){
        return "TODO";
    }

    /**
     *  Sets the default/initial state for each rotor
     */
    void configureRotors(){
        setState("A","B","C","D");
    }

    /**
     *  Sets the default/initial state of the plugboard
     */
    void configurePlugboard(){
        this.plugboard.connect("A","G");
        this.plugboard.connect("B","F");
        this.plugboard.connect("C","E");
        this.plugboard.connect("D","H");
    }

    /**
     *  Sets the new state for each rotor. States are a single character in the range [65, 90]
     * @param r1 - Rotor 1
     * @param r2 - Rotor 2
     * @param r3 - Rotor 3
     * @param r4 - Rotor 4
     */
    public void setState(String r1, String r2, String r3, String r4){
        setState(new String[]{r1,r2,r3,r4});
    }

    /**
     *  Sets the new state for each rotor. The input array should be 4 strings long, with each
     *    string being a single character in the range [65, 90]
     * @param s - Array of new states for the rotors
     */
    public void setState(String[] s){
        if(s.length == 4){
            for(int i = 0; i < this.rotors.length; i++){
                this.rotors[i].setState(s[i]);
            }
        }
    }

    /**
     *
     * @return - A string of each rotor state, separated by spaces.
     */
    public String getRotorStates(){
        return rotors[0] + " " + rotors[1] + " " + rotors[2] + " " + rotors[3];
    }
}
