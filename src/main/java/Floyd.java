import java.util.Scanner;

/**
 * Created by pparth on 5/15/16.
 */
public class Floyd {
    public static int nodes;
    public static int edges;
    public static int[][] adj;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        adj = new int[nodes+1][nodes+1];
        for(int i = 1;i<=nodes;i++) {
            for(int j=1;j<=nodes;j++) {
                adj[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
            }
        }
        int a,b,wt, newDis;
        for(int i=0;i<edges;i++) {
            a = in.nextInt();
            b=in.nextInt();
            wt = in.nextInt();
            adj[a][b] = wt;
        }

        for(int curr = 1;curr<=nodes;curr++) {
            for(int i=1;i<=nodes;i++) {
                for(int j=1;j<=nodes;j++) {
                    if(adj[i][curr] == Integer.MAX_VALUE || adj[curr][j] == Integer.MAX_VALUE) {
                        newDis = Integer.MAX_VALUE;
                    } else {
                        newDis = adj[i][curr] + adj[curr][j];
                    }
                    adj[i][j] = Math.min(adj[i][j], newDis);
                }
            }
        }
        int queries = in.nextInt();
        for(int i=0;i<queries;i++) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println((adj[a][b] == Integer.MAX_VALUE) ? -1 : adj[a][b]);
        }
    }

}
