public class Plugboard {
    private int[] connections = new int[26];
    private int ascii_offset = 65;

    /**
     *  The plugboard for the machine.
     *
     *  TODO - Double check this:
     *  As far as I'm aware, this converts characters that go into and out of the rotor set.
     */
    Plugboard(){

    }

    /**
     *  Connects two plugs in the plugboard - is like a non-directional graph, but the plug can only
     *    connect to a single other plug.
     * @param s1 - A letter to connect to
     * @param s2 - A different letter to connect to
     */
    void connect(String s1, String s2){
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();

        if(
            s1.length() == s2.length()    &&
            s1.length() == 1              &&
            s1.charAt(0) != s2.charAt(0)
        ){
            connect(s1.charAt(0) - ascii_offset, s2.charAt(0) - ascii_offset);
        }
    }

    /**
     *  Connects two plugs in the plugboard - is like a non-directional graph, but the plug can only
     *    connect to a single other plug.
     * @param a - integer corresponding to the index of the letter
     * @param b - integer corresponding to the index of the letter
     */
    private void connect(int a, int b){
        this.connections[a] = b;
        this.connections[b] = a;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for(int i = 0; i < this.connections.length; i++){
            sb.append("[ ");
            sb.append(
                    (char)(i + ascii_offset)
            );
            sb.append(" : ");
            sb.append(
                    (char)(this.connections[i] + ascii_offset)
            );
            sb.append(" ]");

            if(i + 1 < this.connections.length){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
