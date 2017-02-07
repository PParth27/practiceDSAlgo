package sears;

import java.util.Scanner;

/**
 * Created by pparth on 10/23/16.
 */
public class lcm {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] jhd) {
        Scanner in = getScanner();

        int t = in.nextInt();
        boolean flag;
        while(t>0) {
            flag = false;
            int n = in.nextInt();
            int k =in.nextInt();
            for(int i=0;i<n;i++) {
                int curr = in.nextInt();
                if(curr%k == 0) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if(!flag)
                System.out.println("NO");
            t--;
        }
    }
}
