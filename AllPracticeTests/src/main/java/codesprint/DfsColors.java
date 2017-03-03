package codesprint;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pparth on 5/22/16.
 */
public class DfsColors {

    public static int[] colorOfNodes;
    public static long diffCount;
    public static LinkedList<Integer>[] adj;

    static void dfs(int n, long count, int parent, int[] colorDone) {
        int[] colorDone2 = colorDone.clone();
        long newCount = count;
        if (colorDone2[colorOfNodes[n]] != 1) {
            colorDone2[colorOfNodes[n]] = 1;
            newCount += 1;
        }
        diffCount += newCount;
        if (adj[n] != null) {
            for (Integer curr : adj[n]) {
                if (curr != parent)
                    dfs(curr, newCount, n, colorDone2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        colorOfNodes = new int[n+1];
        adj = new LinkedList[n+1];
        for(int i = 1;i<=n;i++) {
            colorOfNodes[i] = in.nextInt();
        }

        for(int i=0;i<n-1;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(adj[a] == null) {
                adj[a] = new LinkedList<>();
            }
            if(adj[b] == null) {
                adj[b] = new LinkedList<>();
            }
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1;i<=n;i++) {
            int[] hashColor = new int[n+1];
            diffCount = 0;
            dfs(i, 0, 0, hashColor);
            System.out.println(diffCount);
        }
    }
}
