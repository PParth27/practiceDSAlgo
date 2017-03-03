package Hack101;


import java.util.Scanner;

/**
 * Created by pparth on 8/23/16.
 */
public class Laser {
    public static void main(String[] args) {
        int n, m, currPos;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long[] heights = new long[n+1];
        long iniSum = 0;
        for(int i=1;i<=n;i++) {
            heights[i] = in.nextLong();
            iniSum+=heights[i];
        }
        m = in.nextInt();
        for(int k=0;k<m;k++) {
            currPos = in.nextInt();
            for(int i=currPos-1, j=1;i>=1;i--, j++) {
                if(heights[i] > j) {
                    iniSum-=(heights[i] - j);
                    heights[i] = j;
                }
            }
        }
        System.out.print(iniSum);
    }
}
