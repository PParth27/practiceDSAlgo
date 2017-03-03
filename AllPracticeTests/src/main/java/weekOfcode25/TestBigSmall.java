package weekOfcode25;

import java.util.Scanner;

/**
 * Created by pparth on 11/3/16.
 */
public class TestBigSmall {
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
            long count = 0;
            if(d==0) {
                System.out.println(0);
            } else {
                while(true) {
                    if (left > 2 * b) {
                        count++;
                        left -= b;
                    } else {
                        if(left<b) {
                            if(b-left < left) {

                            }
                        }
                        if (left == a || left == b) {
                            count++;
                        } else {
                            count += 2;
                        }
                        break;
                    }
                }
                System.out.println(count);
            }
            q--;
        }
    }
}
