package CodeSprint7;

import java.util.Scanner;

/**
 * Created by pparth on 9/24/16.
 */
public class Socks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] val = new int[101];

        for(int i =1;i<=n;i++) {
            val[in.nextInt()]++;
        }
        int sum = 0;
        for(int i=0; i< val.length;i++) {
            sum += val[i] / 2;
        }
        System.out.println(sum);
    }
}
