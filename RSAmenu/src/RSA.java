import java.math.BigInteger;
import java.util.Random;

public class RSA {

    // Variables
    private BigInteger P;
    private BigInteger Q;
    private BigInteger N;
    private BigInteger r;
    private BigInteger e;
    private BigInteger d;
    private int max = 1024;
    private Random R;

    public RSA(){
        // Random used to get a random prime number
        R = new Random();
        // P and Q are random prime numbers below 1024
        P = BigInteger.probablePrime(max, R);
        Q = BigInteger.probablePrime(max, R);
        // N = P*Q
        N = P.multiply(Q);
        // r = (P - 1)*(Q - 1)
        r = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
        // e is a random prime number below 512
        e = BigInteger.probablePrime(max/2, R);
        // Checks if gcd(e,r) >= 1 and if e is less than r
        while (r.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(r) < 0);
            {
                e.add(BigInteger.ONE);
            }
        // d = e^-1mod(r)
        d = e.modInverse(r);
    }
    // Constructor
    public RSA(BigInteger e, BigInteger d, BigInteger N){
        this.e = e;
        this.d = d;
        this.N = N;
    }
    // This method is used to split an array of bytes into a String
    public static String split(byte[] cipher){
        String temp = "";
        for (byte i : cipher)
            {
                temp += Byte.toString(i);
            }
        return temp;
        }
    // This method is used encrypt a message using the public key
    public byte[] encrypt(byte[] message){
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }
    // This method is used to decrypt a message using the private key
    public byte[] decrypt(byte[] message){
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }
}
