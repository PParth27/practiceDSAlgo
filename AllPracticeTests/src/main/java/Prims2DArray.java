import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 5/15/16.
 */
public class Prims2DArray {
    public static int nodes;
    public static int edges;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        int[][] adj = new int[nodes+1][nodes+1];
        for(int i=1;i<=nodes;i++) {
            for(int j=1;j<=nodes;j++) {
                adj[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges;i++) {
            int a, b, wt;
            a = in.nextInt();
            b = in.nextInt();
            wt = in.nextInt();
            adj[a][b] = (adj[a][b] != 0) ? Math.min(wt, adj[a][b]) : wt;
            adj[b][a] = (adj[b][a] != 0) ? Math.min(wt, adj[b][a]) : wt;
        }
        int[] wts = new int[nodes+1];
        for(int i=1;i<=nodes;i++) {
            wts[i] = Integer.MAX_VALUE;
        }
        int start = in.nextInt();
        wts[start] = 0;
        int[] inMst = new int[nodes+1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nodes+1, (Integer a, Integer b) -> wts[a] - wts[b]);
        for(int i=1;i<=nodes;i++) {
            priorityQueue.add(i);
        }
        int sum =0;
        while(!priorityQueue.isEmpty()) {
            int curr = priorityQueue.poll();
            inMst[curr] = 1;
            sum+=wts[curr];
            for(int val=1;val<nodes+1;val++) {
                if(adj[curr][val] != Integer.MAX_VALUE && inMst[val] == 0) {
                    if (wts[val] > adj[curr][val]) {
                        priorityQueue.remove(val);
                        wts[val] = adj[curr][val];
                        priorityQueue.add(val);
                    }
                }
            }
        }
        System.out.print(sum);
    }
}
