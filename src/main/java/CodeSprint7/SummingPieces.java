package CodeSprint7;

import java.util.Scanner;

/**
 * Created by pparth on 9/26/16.
 */
public class SummingPieces {
    public static void main(String[] dhb) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n+1];
        long modu = 1000000007;
        for(int i=0;i<n;i++) {
            arr[i] = in.nextLong();
        }
        long ans = 0;
        int k = n;
        long prev = 0, curr;
        int fix = -1;
        for(int i=0, j=n-1;i<=j;i++, j--) {
            curr = prev + (long)(Math.pow(2, k) - 1 + (fix > 0 ? 1 : 0))%modu;
            ans = ans + (((i!=j) ? arr[i] + arr[j] : arr[i]) * (curr % modu)) % modu;
            prev = curr;
            k-=2;
            fix++;
        }
        System.out.print(ans);
    }

}
