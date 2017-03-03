package amazon;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pparth on 7/9/16.
 */
public class ConnectedChanges {
    public static int[] visited;
    public static int[] know;
    public static LinkedList<Integer>[] adj;
    public static int hKnow = 0;
    public static long knowNum = 0;
    public static BigInteger modu = new BigInteger("1000000007");
    public static void dfs(int n) throws Exception {
        try {
            if (adj[n] != null) {
                for (int node : adj[n]) {
                    if (visited[node] == 0) {
                        visited[node] = 1;
                        if (know[node] == hKnow) {
                            knowNum = ((knowNum) + 1);
                        } else if (know[node] > hKnow) {
                            hKnow = know[node];
                            knowNum = 1;
                        }
                        dfs(node);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int nodes = in.nextInt();
            int edges = in.nextInt();
            int a, b;
            visited = new int[nodes + 1];
            know = new int[nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                know[i] = in.nextInt();
            }
            adj = new LinkedList[nodes + 1];
            for (int i = 0; i < edges; i++) {
                a = in.nextInt();
                b = in.nextInt();
                if (adj[a] == null) {
                    adj[a] = new LinkedList<>();
                }
                if (adj[b] == null) {
                    adj[b] = new LinkedList<>();
                }
                adj[a].add(b);
                adj[b].add(a);
            }
            BigInteger answer = new BigInteger("1");

            for (int i = 1; i <= nodes; i++) {
                hKnow = 0;
                knowNum = 0;
                if (visited[i] != 1) {
                    hKnow = know[i];
                    knowNum = 1;
                    visited[i] = 1;
                    dfs(i);

                    answer = ((answer.mod(modu)).multiply(BigInteger.valueOf(knowNum).mod(modu)).mod(modu));
                }
            }
            System.out.print(answer.mod(modu));
        } catch (Exception e) {
            System.out.print(0);
        }
    }
}
