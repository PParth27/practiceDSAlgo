package Hac41;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 9/20/16.
 */
public class ModifiedKnapGreed {

    private static class Worth {
        int i;
        long val;

        public Worth(int i, long val) {
            this.i = i;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, k;
        n = in.nextInt();
        k = in.nextInt();
        if(k>n)
            k=n;

        long[] p = new long[n + 1];
        long[] d = new long[n + 1];
        int[] doIt = new int[n+1];
        PriorityQueue<Worth> pq = new PriorityQueue<>(n + 1, (Worth a, Worth b) -> (int)(b.val - a.val));
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextLong();
            d[i] = in.nextLong();
            pq.add(new Worth(i, p[i] + d[i]));
        }
        while(k>0) {
            doIt[pq.poll().i] = 1;
            k--;
        }
        long sum =0;
        for(int i=1;i<=n;i++) {
            if(doIt[i] == 1) {
                sum+=p[i];
            } else {
                sum-=d[i];
            }
        }
        System.out.println((sum < 0) ? 0 : sum);
    }
}
