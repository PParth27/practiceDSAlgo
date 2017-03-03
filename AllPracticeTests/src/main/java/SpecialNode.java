import java.io.*;
import java.util.*;

public class SpecialNode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numV = in.nextInt();
        long[][] adjMatrix = new long[numV+1][numV+1];
        for(int i=1;i<=numV;i++) {
            for(int j=1;j<=numV;j++) {
                if(i==j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int numE = in.nextInt();
        for(int i=0;i<numE;i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int wt = in.nextInt();
            adjMatrix[v1][v2] = wt;
            adjMatrix[v2][v1] = wt;
        }
        int numS = in.nextInt();
        int[] special = new int[numS];
        for(int i=0;i<numS;i++) {
            special[i] = in.nextInt();
        }

        for(int k=1;k<=numV;k++) {
            for(int i=1;i<=numV;i++) {
                for(int j=1;j<=numV;j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], (adjMatrix[i][k] == Integer.MAX_VALUE ||
                            adjMatrix[k][j] == Integer.MAX_VALUE) ? Integer
                            .MAX_VALUE :
                            adjMatrix[i][k] +
                                    adjMatrix[k][j]);
                }
            }
        }
        long min;
        for(int i=1;i<=numV;i++) {
            min = Integer.MAX_VALUE;
            for(int j=0;j<numS;j++) {
                if(adjMatrix[i][special[j]] < min) {
                    min = adjMatrix[i][special[j]];
                }
            }
            System.out.println(min);
        }
    }
}