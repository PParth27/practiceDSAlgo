package codeSprint6;


import java.util.Scanner;

/**
 * Created by pparth on 8/28/16.
 */
public class FlipMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int n;
        long sum;
        int[][] arr;
        for (int l = 0; l < q; l++) {
            n = in.nextInt();
            arr = new int[2*n+1][2*n+1];
            sum=0;
            for(int i=1;i<=2*n;i++) {
                for(int j=1;j<=2*n;j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    sum+=(Math.max(Math.max(arr[i][j], arr[2*n - i + 1][2*n - j +1]), Math.max(arr[2*n+1-i][j],
                            arr[i][2*n+1-j])));
                }
            }
            System.out.println(sum);
        }
    }
}
