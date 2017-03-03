package CodeWeek23;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 9/18/16.
 */
public class SwapYo {

    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }
}
