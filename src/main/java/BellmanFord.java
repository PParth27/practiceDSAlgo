import java.util.Scanner;

/**
 * Created by pparth on 5/21/16.
 */
public class BellmanFord {

    public static class Edge {
        int from;
        int to;
        long wt;

        public Edge(int from, int to, long wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a, b;
        Long wt;
        for (int xx = 0; xx < t; xx++) {
            int nodes = in.nextInt();
            int edges = in.nextInt();
            long[] minDis = new long[nodes + 1];
            Edge[] allEdges = new Edge[nodes + 1];
            for (int i = 1; i <= edges; i++) {
                a = in.nextInt();
                b = in.nextInt();
                wt = in.nextLong();
                allEdges[i] = new Edge(a, b, wt);
            }
            int start = in.nextInt();
            for(int i=1;i<=nodes;i++) {
                minDis[i] = Long.MAX_VALUE;
            }
            minDis[start] = 0L;

            for (int i=1;i<nodes;i++) {
                for (int j=1;j<=edges;j++) {
                    Edge curr = allEdges[j];
                    if(minDis[curr.from] != Long.MAX_VALUE && minDis[curr.to] > minDis[curr.from] + curr.wt) {
                        minDis[curr.to] = minDis[curr.from] + curr.wt;
                    }
                    if(minDis[curr.to] != Long.MAX_VALUE && minDis[curr.from] > minDis[curr.to] + curr.wt) {
                        minDis[curr.from] = minDis[curr.to] + curr.wt;
                    }
                }
            }
            for (int i = 1; i <= nodes; i++) {
                if (i != start) {
                    System.out.print((minDis[i] != Long.MAX_VALUE) ? minDis[i] + " ": -1 + " ");
                }
            }
            System.out.print("\n");
        }
    }
}
