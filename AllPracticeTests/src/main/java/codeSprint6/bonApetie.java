package codeSprint6;

import java.util.Scanner;

/**
 * Created by pparth on 8/28/16.
 */
public class bonApetie {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long tobeCharged = 0;
        long curr;
        for(int i=0;i<n;i++) {
            curr = in.nextLong();
            if(i!=k) {
                tobeCharged+=curr;
            }
        }
        long charged = in.nextLong();
        long val = charged - (tobeCharged/2);
        if(val == 0L) {
            System.out.println("Bon Appetit");
        }else {
            System.out.println(val);
        }
    }
}
