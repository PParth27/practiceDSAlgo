package amazon2;

import java.util.Scanner;

/**
 * Created by pparth on 10/23/16.
 */
public class Houses {
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

        int[][] sol = new int[n+1][n+1];
        int cons, ans, var;
        for(int i =1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i>=j) {
                    continue;
                }
                else {
                    ans = 0;
                    ans = (ans + sol[i][j-1]) % modu;
                    cons = j;
                    var = j-1;
                    while (var>=i) {
                        if(isSpecial(var-1, cons-1))
                            ans = (ans + 1) % modu;
                        var--;
                    }
                    sol[i][j] = ans;
                }
            }
        }
        int q = in.nextInt();
        while (q>0) {
            System.out.println(sol[in.nextInt()][in.nextInt()]);
            q--;
        }
    }
}
