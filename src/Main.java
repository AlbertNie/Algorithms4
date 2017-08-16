import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by albert on 2017/7/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder test = new StringBuilder(in.nextLine());
        in.close();
        long Q = longRandomPrime();

    }
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31,new Random());
        return prime.longValue();
    }
}
