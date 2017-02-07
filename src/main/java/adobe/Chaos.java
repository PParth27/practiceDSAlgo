package adobe;

import java.util.Scanner;

/**
 * Created by pparth on 11/3/16.
 */
public class Chaos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n+1];
            for(int q_i=1; q_i <= n; q_i++){
                q[q_i] = in.nextInt();

            }
            int sum=0;
            for (int i = 1; i <= n; i++) {
                if(i+1<=n && q[i] > q[i+1]) {
                    int tmp = q[i];
                    q[i] = q[i+1];
                    q[i+1] = tmp;
                    sum++;
                }
                if(i+2<=n && q[i] > q[i+2]) {
                    int tmp = q[i];
                    q[i] = q[i+2];
                    q[i+2] = tmp;
                    sum++;
                }
            }
            boolean isChaotic = false;
            for(int i=1;i<=n;i++) {
                if(q[i]!=i) {
                    isChaotic = true;
                    break;
                }
            }
            if(isChaotic) {
                System.out.println("Too chaotic");
            } else {
                System.out.println(sum);
            }
        }
    }
}
