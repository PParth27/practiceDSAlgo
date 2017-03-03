import java.io.*;
import java.util.*;

public class Solution {

    public static long num;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */      Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++) {
            num=0;
            int dimensions = in.nextInt();
            int steps = in.nextInt();
            int[] currPos = new int[dimensions];
            int[] limits = new int[dimensions];
            for(int j=0;j<dimensions;j++) {
                currPos[j] = in.nextInt();
            }
            for(int j=0;j<dimensions;j++) {
                limits[j] = in.nextInt();
            }
            countWays(steps, currPos, limits);
            System.out.println(num);
        }
    }

    public static void countWays(int steps, int[] currPos, int[] limits) {
        if(steps == 0) {
            num = (num + 1) % 1000000007;
            return;
        } else {
            for(int k=0;k<currPos.length;k++) {
                if(currPos[k] + 1 <= limits[k]) {
                    int[] copyArray = currPos.clone();
                    copyArray[k] = copyArray[k]+1;
                    countWays(steps-1, copyArray, limits);
                }
                if(currPos[k] - 1 > 0) {
                    int[] copyArray = currPos.clone();
                    copyArray[k] = copyArray[k] - 1;
                    countWays(steps-1, copyArray, limits);
                }
            }
        }
    }
}