package walmart2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 10/30/16.
 */
public class Mountains {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static final long modu = 1000000007;

    public static void main(String[] gfh) {
        Scanner in = getScanner();
        int t = in .nextInt();
        long[] catalan = new long[4001];
        catalan[0] = 1;
        catalan[1] = 1;

        for (int i =2;i<=2001;i++) {
            catalan[i] = 0;
            for(int j = 0;j<i;j++) {
                catalan[i] = (catalan[i] % modu + ((catalan[j] % modu) * (catalan[i-j-1] % modu)) % modu) % modu;
            }
        }
        while (t>0) {
            int n = in.nextInt();
            long ans = 0;
            for(int i = 1;i<=n/2;i++) {
                ans = (ans % modu + catalan[i] % modu) % modu;
            }
            System.out.println(ans);
            t--;
        }
    }
}
