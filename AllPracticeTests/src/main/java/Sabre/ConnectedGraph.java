package Sabre;

import java.util.Scanner;

/**
 * Created by pparth on 10/2/16.
 */
public class ConnectedGraph {
    static int nodes;
    static int edges;
    static int[][] adj;
    static int[] visited;
    static int removeNode;
    static boolean isConnected;

    public static void initializeAdj() {
        visited = new int[nodes+1];
        adj = new int[nodes+1][nodes+1];
    }

    public static void addEdge(int from, int to) {
        adj[from][to] = 1;
    }

    public static void dfs(int node) {
        if(visited[node] == 0) {
            visited[node] = 1;
            for (int i = 1; i <= nodes; i++) {
                if (adj[node][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void isConnected() {
        int start = 1;
        while(start == removeNode){
            start++;
        }
        dfs(start);
        isConnected = true;
        for(int i =1;i<=nodes;i++) {
            if(visited[i] == 0) {
                isConnected = false;
            }
        }
    }

    public static void main(String [] sjdfn) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        initializeAdj();
        for (int i = 0; i < edges; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            addEdge(a + 1, b + 1);
            addEdge(b + 1, a + 1);
        }
        removeNode = in.nextInt()+1;
        visited[removeNode] = 1;
        for(int i = 1;i<=nodes;i++) {
            adj[removeNode][i] = 0;
            adj[i][removeNode] = 0;
        }
        isConnected();
        if(isConnected)
            System.out.println("Connected");
        else {
            System.out.println("Not Connected");
        }
    }
}
