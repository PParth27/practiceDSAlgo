package DceCoders;

import java.util.Scanner;

/**
 * Created by pparth on 10/19/16.
 */
public class Intest {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] ahgd) {
        Scanner in = getScanner();

        int k = in.nextInt();
        int div = in.nextInt();
        int sum=0;
        while (k>0) {
            if(in.nextInt()%div == 0)
                sum++;
            k--;
        }
        System.out.print(sum);
    }
}
