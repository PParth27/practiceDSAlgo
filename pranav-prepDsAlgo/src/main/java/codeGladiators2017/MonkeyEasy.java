package codeGladiators2017;

import java.util.Scanner;

/**
 * Created by pparth on 4/14/17.
 */
public class MonkeyEasy {
    public static void main(String[] oo) {
        int x,y, n;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        n = in.nextInt();
        int oneJump = x-y;
        int sum = 0;
        for(int i=0;i<n;i++) {
            int curr = in.nextInt();
            if (curr%oneJump <= y) {
                if(curr/oneJump != 0)
                    sum+=curr/oneJump;
                else
                    sum+=1;
            } else {
                sum+=curr/oneJump + 1;
            }
        }
        System.out.println(sum);
    }
}
