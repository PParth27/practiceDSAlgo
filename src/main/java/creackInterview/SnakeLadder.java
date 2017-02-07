package creackInterview;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by pparth on 10/2/16.
 */
public class SnakeLadder {

    static int nodes;
    static int edges;
    static LinkedList<Integer>[] adj;
    static int[] visited;
    static int count;
    static int[] dis;
    static boolean conti;
    static boolean found;
    /**
     * Initialize adj nodes for all.
     */
    public static void initializeAdj() {
        visited = new int[nodes+1];
        adj = new LinkedList[nodes+1];
        for(int i=1;i<=nodes;i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public static void addEdge(int from, int to) {
        adj[from].add(to);
    }


    public static void setEdgesForBoard(int[] hash) {
        for(int i=1;i<=100;i++) {
            int k = 1;
            while(k<=6) {
                if (i+k<=100) {
                    if (hash[i + k] == 0)
                        addEdge(i, i + k);
                    else
                        addEdge(i, hash[i + k]);
                }
                k++;
            }
        }
    }

    static void dfs(int node, int find) {
        if(!conti)
            return;
        visited[node] = 1;
        if(node == find) {
            System.out.println(count);
            conti = false;
        }
        adj[node].stream().forEach(a ->  {
            if(visited[a] != 0){
                dfs(a, find);
            }
        });
    }

    static void bfs(int start, int find) {
        Queue<Integer> que= new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {
            int curr = que.poll();
            visited[curr] = 1;
            if(curr == find) {
                found = true;
                System.out.println(dis[curr]);
                return;
            } else {
                adj[curr].stream().forEach(a -> {
                    if(visited[a] == 0) {
                        que.add(a);
                        dis[a] = Math.min(dis[curr]+1, dis[a]);
                    }
                });
            }
        }
    }

    public static void main(String [] sjdfn) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0) {
            found = false;
            int[] hash = new int[101];
            conti = false;
            dis = new int[101];
            for(int i=1;i<=100;i++)
                dis[i] = Integer.MAX_VALUE;
            count=0;
            nodes = 100;
            initializeAdj();
            int l = in.nextInt();
            for(int i=0;i<l;i++) {
                hash[in.nextInt()] = in.nextInt();
            }
            int s = in.nextInt();
            for(int i=0;i<s;i++) {
                hash[in.nextInt()] = in.nextInt();
            }
            setEdgesForBoard(hash);
            //dfs(1,100);
            dis[1] = 0;
            bfs(1,100);
            if(!found)
                System.out.println(-1);
            t--;
        }
    }
}
