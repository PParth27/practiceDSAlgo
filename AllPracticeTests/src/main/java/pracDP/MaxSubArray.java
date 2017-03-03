package pracDP;

import java.util.Scanner;

/**
 * Created by pparth on 9/23/16.
 */
public class MaxSubArray {

    public static void main(String[] brgs) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t> 0) {
            int n = in.nextInt();
            int[] arr = new int[n+1];
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt();
            }
            int[][] dp = new int[n+1][n+1];
            int ans = Integer.MIN_VALUE;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(i == 0 && j==0) {
                        dp[i][j] = arr[i];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1] + arr[j], arr[j]);
                        if(dp[i][j] > ans)
                            ans = dp[i][j];
                    }
                }
            }
            t--;
        }
    }

}
