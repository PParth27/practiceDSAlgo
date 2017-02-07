package SeptClash;

import java.util.Scanner;

/**
 * Created by pparth on 9/10/16.
 */
public class KGCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        long[] dp = new long[4+1];
        long count;
        dp[1] = 1;
        for(int k=2;k<=4;k++) {
            count=dp[k-1];
            for(int i=1;i<=k;i++) {
                if(i-k == i%k || k-i == i%k)
                    count++;
                if(k-i == k%i || i-k == k%i)
                    count++;
            }
            dp[k] = count;
        }

        while(t>0) {
            long n = in.nextLong();
            if(n<=1000000) {
                System.out.println(dp[(int)n]);
            } else {
                System.out.println(0);
            }
            t--;
        }
    }
}
