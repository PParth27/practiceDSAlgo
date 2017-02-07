package walmart2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 10/29/16.
 */
public class Combi {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    static BigInteger binomial(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    public static void main(String[] po) {
        Scanner in = getScanner();
        int n = in.nextInt();
        int k = in.nextInt();
        BigInteger total = BigInteger.valueOf(k);
        BigInteger ans = BigInteger.ZERO;
        for(int i = 1;i<=n;i++) {
            ans = ans.add(binomial(n, i));
        }
        System.out.print(ans.subtract(total).abs());
    }
}
