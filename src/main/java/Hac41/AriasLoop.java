package Hac41;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 9/20/16.
 */
public class AriasLoop {

    private static long modu = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int k = in.nextInt();

        System.out.println(binomial(n,k));
    }

    static BigInteger binomial(final long N, final long K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1)).mod(BigInteger.valueOf(modu));
        }
        return ret;
    }

}
