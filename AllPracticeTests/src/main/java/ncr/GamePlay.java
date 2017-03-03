package ncr;

import java.util.Scanner;

/**
 * Created by pparth on 11/7/16.
 */
public class GamePlay {
    public static void main(String[] uhk) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while(q>0) {
            int l = in.nextInt();
            int r = in.nextInt();
            int k =in.nextInt();
            int val = l+r;
            if(k < l) {
                System.out.println("Bob");
                q--;
                continue;
            }

            int div = k/val;
            int rem = k%val;

            if(rem == 0 || rem > r ) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }

//            if(k%val == 0 || (k<val && k>r)) {
//                System.out.println("Bob");
//            } else {
//                System.out.println("Alice");
//            }
            q--;
        }
    }
}
