package pracDP;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 9/23/16.
 */
public class FiboWithBigInt {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        BigInteger iminus1 = BigInteger.valueOf(b);
        BigInteger iminus2 = BigInteger.valueOf(a);
        BigInteger ans = new BigInteger("0");
        int k = 3;
        while(k<=n) {
            ans = iminus2.add(iminus1.multiply(iminus1));
            iminus2 = iminus1;
            iminus1 = ans;
            k++;
        }
        System.out.print(ans);
    }
}
