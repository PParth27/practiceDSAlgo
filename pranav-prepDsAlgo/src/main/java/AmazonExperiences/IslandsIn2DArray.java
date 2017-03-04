package AmazonExperiences;

import java.util.Scanner;

/**
 * Here we are doing a DFS to find the number of islands, and also the biggest lisland size(number of 1's in that
 * island). Thing to note is how all the 8 adj neighbours of a i,j are accessed here using iAdd and jAdd. THats
 * awesome. makes our lives sp much easier. :P
 */
public class IslandsIn2DArray {

    public static int maxOnes = Integer.MIN_VALUE;
    static int count = 0;
    public static boolean[][] visited;
    static int[] iAdd = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] jAdd = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n, m;

    static int dfs(int[][] arr, int i, int j) {
        visited[i][j] =true;
        int sum = 1;
        for(int jj=0;jj<8;jj++) {
            int newI = i+iAdd[jj];
            int newJ = j+jAdd[jj];
            if(newI>=1 && newI<=n && newJ>=1 && newJ<=m && !visited[newI][newJ] && arr[newI][newJ] == 1) {
                sum += dfs(arr, newI, newJ);
            }
        }
        return sum;
    }

    public static void main(String[] ppp) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        int arr[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                arr[i][j] = in.nextInt();

        visited = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    maxOnes = Math.max(dfs(arr, i, j), maxOnes);
                    count++;
                }
            }
        }
        System.out.println(maxOnes + "\n" + count);
    }
}
