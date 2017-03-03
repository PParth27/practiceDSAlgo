package weekOfcode25;

import java.util.Scanner;

/**
 * Created by pparth on 11/2/16.
 */
public class BigSmallStep {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] pp) {
        Scanner in = getScanner();

        int q = in.nextInt();

        while(q>0) {
            int a = in.nextInt();
            int b = in.nextInt();

            int d = in.nextInt();
            int left  = d;
            int count = 0;
            if(d==0) {
                System.out.println(0);
            } else {
                if(d%b == 0) {
                    count+=d/b;
                } else {
                    int steps;
                    if(d/b==0) {
                        steps =0;
                    } else {
                        steps = (d / b) - 1;
                    }
                    count+=steps;
                    if(d-steps*b == a || d-steps*b == b) {
                        count+=1;
                    } else {
                        count+=2;
                    }
                }
                System.out.println(count);
            }
            q--;
        }
    }
}
