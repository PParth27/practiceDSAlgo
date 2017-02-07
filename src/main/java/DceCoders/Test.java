package DceCoders;

import java.util.Scanner;

/**
 * Created by pparth on 10/19/16.
 */
public class Test {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        int n = -1;
        Scanner in = getScanner();
        while(true) {
            n = in.nextInt();
            if(n==42)
                return;
            else {
                System.out.println(n);
            }
        }
    }
}

