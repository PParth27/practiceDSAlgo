import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 6/12/16.
 */
public class blackRock {

    static BigInteger findBinomial(int n, int k) {
        BigInteger ret = BigInteger.ONE;
        for (int k1 = 0; k1 < k; k1++) {
            ret = ret.multiply(BigInteger.valueOf(n-k1))
                    .divide(BigInteger.valueOf(k1+1));
        }
        return ret;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String val = in.next();
        int len = val.length();
        long aCount = 0;
        long bCount = 0;
        for(char curr : val.toCharArray()) {
            if(curr == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }
        if(len%2 != 0) {
            System.out.println("0");
        } else if(aCount != 0 && bCount != 0 && aCount != bCount){
            System.out.println("0");
        } else if(aCount == 0 || bCount == 0){
            System.out.println(findBinomial(len, len/2));
        } else {
            System.out.println(findBinomial(len, len/2).longValue() - aCount);
        }
    }
}
