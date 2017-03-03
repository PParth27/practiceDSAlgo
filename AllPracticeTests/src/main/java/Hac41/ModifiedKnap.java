package Hac41;

import java.util.Scanner;

/**
 * Created by pparth on 9/20/16.
 */
public class ModifiedKnap {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,k;
        n = in.nextInt();
        k = in.nextInt();
        if(k > n)
            k = n;
        int[] p = new int[n+1];
        int[] d = new int[n+1];

        for(int i=1;i<=n;i++) {
            p[i] = in.nextInt();
            d[i] = in.nextInt();
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                if(i==0) {
                    dp[i][j] = 0;
                }else if (j==0) {
                    dp[i][j] = dp[i-1][j] - d[i];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + p[i], dp[i - 1][j] - d[i]);
                }
            }
        }
        System.out.println((dp[n][k] < 0) ? 0 : dp[n][k]);
    }
}
