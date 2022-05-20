import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);


    public static void main (String[] args) {

        System.out.println("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        scanner.close();

        Encode encrypt = new Encode();
        encrypt.setOffsetValue('B');
        System.out.println("Encoded text: " + encrypt.encode(plaintext));
        encrypt.setOffsetValue('F');
        System.out.println("Encoded text: " + encrypt.encode(plaintext));



        Decode decrypt = new Decode();
        System.out.println("Decoding " + encrypt.getEncodedText() + " as: " + decrypt.decode(encrypt.getEncodedText()));



    }

}