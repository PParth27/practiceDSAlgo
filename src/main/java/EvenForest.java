import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pparth on 5/15/16.
 */
public class EvenForest {
    public static int nodes;
    public static int edges;
    public static LinkedList<Integer>[] adj;
    public static int count = 0;
    public static int[] visited;
    public static int getMaxCut(int start) {
        int val,downCount;
        visited[start] = 1;
        if(adj[start].size() == 1 && visited[adj[start].get(0)] == 1) {
            return 1;
        } else {
            downCount = 0;
            for(Integer curr : adj[start]) {
                if(visited[curr] == 0) {
                    val = getMaxCut(curr);
                    if(val%2 == 0)
                        count++;
                    downCount += val;
                }
            }
            return downCount+1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        adj = new LinkedList[nodes+1];
        visited = new int[nodes+1];
        int a,b;
        for(int i=0;i<edges;i++) {
            a = in.nextInt();
            b = in.nextInt();
            if(adj[a] == null) {
                adj[a] = new LinkedList<>();
            }
            if(adj[b] == null) {
                adj[b] = new LinkedList<>();
            }
            adj[a].add(b);
            adj[b].add(a);
        }
        if(nodes == 2) {
            System.out.print(0);
        } else {
            getMaxCut(2);
            System.out.print(count);
        }
    }
}
