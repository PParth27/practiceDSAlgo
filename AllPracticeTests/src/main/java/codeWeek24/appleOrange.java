package codeWeek24;

import java.util.Scanner;

/**
 * Created by pparth on 10/11/16.
 */
public class appleOrange {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] sfg) {
        long s, t, a, b, m, n;
        Scanner in = getScanner();
        s = in.nextLong();
        t = in.nextLong();
        a = in.nextLong();
        b = in.nextLong();
        m = in.nextLong();
        n = in.nextLong();

        long sum1 = 0;
        long sum2=0;

        for(long i =0;i<m;i++) {
            long curr = in.nextLong();
            if (a+curr >= s && a+curr <=t) {
                sum1++;
            }
        }
        System.out.println(sum1);
        for(long i =0;i<n;i++) {
            long curr = in.nextLong();
            if (b+curr >= s && b+curr <=t) {
                sum2++;
            }
        }
        System.out.println(sum2);
    }
}
