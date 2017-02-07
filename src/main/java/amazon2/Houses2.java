package amazon2;

import java.util.Scanner;

/**
 * Created by pparth on 10/23/16.
 */
public class Houses2 {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    static char[] sleep;
    static char[] food;

    public static boolean isSpecial(int x, int y) {
        if(sleep[x] == sleep[y] || food[x] == food[y])
            return true;

        return false;
    }

    public static void main(String[] jh) {
        int modu = 1000000007;
        Scanner in = getScanner();
        int n = in.nextInt();
        food = in.next().toCharArray();
        sleep = in.next().toCharArray();
        int q = in.nextInt();
        while(q>0) {
            int x =in.nextInt();
            int y =in.nextInt();
            long ans = 0;
            for(int i = x;i<=y;i++) {
                for(int j = i+1;j<=y;j++) {
                    if(isSpecial(i-1,j-1)) {
                        ans = ans + 1 % modu;
                    }
                }
            }
            System.out.println(ans);
            q--;
        }
    }
}
