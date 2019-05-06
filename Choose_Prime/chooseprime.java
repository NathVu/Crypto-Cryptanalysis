import java.math.BigInteger;
import java.util.*;

public class chooseprime{
    public static void main(String[] args) {
        Random rand = new Random();
        BigInteger x = BigInteger.probablePrime(1024,rand);
        System.out.println("\n" + x + "\n");
        Random rand2 = new Random();
        BigInteger y = BigInteger.probablePrime(512,rand2);
        System.out.println("\n" + y + "\n");
        System.out.println("\n\n" + x.multiply(y) + "\n\n");
    }
}
