import java.util.Scanner;

public class Driver {
    static String prompt = "Please enter the string for the machine: ";
    static String result = "The encrypted message is: ";
    static Scanner scan = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {

        System.out.print(prompt);
        input = scan.nextLine();

        Enigma e = new Enigma();
        input = e.encryptMessage(input);

        System.out.print(result + input);
    }
}
