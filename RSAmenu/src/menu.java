import java.io.DataInputStream;
import java.io.IOException;

public class menu {
    // Computer Security Coursework Assignment 1
    // by Mohammad Farhaj Miah

    public static void main(String[] args) throws IOException {
        RSA rsa = new RSA();
        // DataInputStream used for user input
        DataInputStream input = new DataInputStream(System.in);
        String msg;
        System.out.println("Enter message you wish to encrypt and send to Bob");
        // Allows user to input a message to send to Bob
        msg = input.readLine();
        System.out.println("Encrypting the message: " + msg);
        // The message is put into a byte array and encrypted
        byte[] cipher = rsa.encrypt(msg.getBytes());
        // The message is then decrypted
        byte[] plain = rsa.decrypt(cipher);
        System.out.println("Encrypted message: " + rsa.split(plain));
        System.out.println("Bob decrypting message received from Alice");
        System.out.println("Decrypted message is: " + new String(plain));
    }
}
