package MyClasses;

import java.util.LinkedList;

/**
 * Created by pparth on 10/2/16.
 */
public class GraphAdjList {
    /**
     * Graph Nodes starting from 1 -- nodes
     */
    static int nodes;
    static int edges;
    static LinkedList<Integer>[] adj = new LinkedList[nodes+1];

    public static int getNodes() {
        return nodes;
    }

    public static void setNodes(int nodes) {
        GraphAdjList.nodes = nodes;
    }

    public static int getEdges() {
        return edges;
    }

    public static void setEdges(int edges) {
        GraphAdjList.edges = edges;
    }

    /**
     * Initialize adj nodes for all.
     */
    public static void initializeAdj() {
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
}
