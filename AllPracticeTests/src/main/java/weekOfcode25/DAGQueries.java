package weekOfcode25;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by pparth on 11/5/16.
 */
public class DAGQueries {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    static LinkedList<Integer>[] adj;
    static boolean[] isVisited;
    static Set<Integer>[] paths;
    static int[] nodeVal;
    static int nodes;
    static int edges;

    public static void bfs(int node) {
        isVisited = new boolean[nodes+1];
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        paths[node] = new HashSet<>();
        isVisited[node] = true;
        paths[node].add(node);
        while (!que.isEmpty()) {
            int curr = que.poll();
            for(Integer next : adj[curr]) {
                if(paths[next] != null) {
                    paths[node].addAll(paths[next]);
                } else {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        paths[node].add(next);
                        que.add(next);
                    }
                }
            }
        }
    }

//    public static void dfs(int node) {
//        LinkedList<Integer> myList = new LinkedList<>();
//        myList.add(node);
//        isVisited[node] = true;
//
//        for(Integer next : adj[node]) {
//            if(paths[next] != null) {
//                myList.addAll(paths[next]);
//            } else {
//                dfs(next);
//                myList.addAll(paths[next]);
//            }
//        }
//        paths[node] = myList;
//    }

    public static void main(String[] gh) {
        Scanner in = getScanner();
        nodes = in.nextInt();
        edges = in.nextInt();
        int q = in.nextInt();

        adj = new LinkedList[nodes+1];
        isVisited = new boolean[nodes+1];
        nodeVal = new int[nodes+1];
        paths = new HashSet[nodes+1];
        for(int i=1;i<=nodes;i++) {
            adj[i] = new LinkedList<>();
        }

        for(int i=0;i<edges;i++) {
            adj[in.nextInt()].add(in.nextInt());
        }

        while (q>0) {
            int op = in.nextInt();
            int u = in.nextInt();
            switch (op) {
                case 1 :
                {
                    int x = in.nextInt();
                    if(paths[u] != null) {
                        for(Integer curr : paths[u]) {
                            nodeVal[curr] = x;
                        }
                    } else {
                        bfs(u);
                        if(paths[u] != null) {
                            for (Integer curr : paths[u]) {
                                nodeVal[curr] = x;
                            }
                        }
                    }
                    break;
                }
                case 2 :
                {
                    int x = in.nextInt();
                    if(paths[u] != null) {
                        for(Integer curr : paths[u]) {
                            if(nodeVal[curr] > x)
                                nodeVal[curr] = x;
                        }
                    } else {
                        bfs(u);
                        if(paths[u] != null) {
                            for(Integer curr : paths[u]) {
                                if(nodeVal[curr] > x)
                                    nodeVal[curr] = x;
                            }
                        }
                    }
                    break;
                }
                case 3 :
                {
                    System.out.println(nodeVal[u]);
                    break;
                }
            }
            q--;
        }
    }
}
