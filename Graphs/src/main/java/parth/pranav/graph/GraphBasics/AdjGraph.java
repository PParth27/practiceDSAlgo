package parth.pranav.graph.GraphBasics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjGraph {
    private int v;
    private int e;
    private List<AdjNode>[] adjList;

    public AdjGraph(int v, int e) {
        this.e = e;
        this.v = v;
        this.adjList = new List[v+1];
        for (int i=0;i<v;i++)
            adjList[i] = new ArrayList<>();
    }

    public void addEdgeUndirected(int source, int dest, int weight) {
        if (adjList[dest] == null) {
            adjList[dest] = new ArrayList<AdjNode>();
        }
        adjList[source].add(new AdjNode(dest, weight));
        adjList[dest].add(new AdjNode(source, weight));
    }

    public void addEdgeDirected(int source, int dest, int weight) {
        adjList[source].add(new AdjNode(dest, weight));
    }

    public void printUsingBFS(int src, Runnable runnable) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        int[] visited = new int[v+1];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr] == 0) {
                visited[curr] = 1;
                System.out.println(curr);
                for (AdjNode adj : adjList[curr]) {
                    queue.add(adj.vertex);
                }
            }
        }
    }

    public void printUsingDFS(int src, int[] visited) {
        System.out.println(src);
        visited[src] = 1;
        for (AdjNode adj : adjList[src]) {
            if (visited[adj.vertex] == 0)
                printUsingDFS(adj.vertex, visited);
        }
    }

    //Expected to be a DAG - KAHN ALGORITHM

    public void printTopologicalSort() {
        int totalVals = 0;
        int[] incomingCount = new int[v+1];
        for (int i=0;i<v;i++) {
            for (AdjNode aa : adjList[i]) {
                incomingCount[aa.vertex]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<v;i++) {
            if (incomingCount[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println(curr);
            totalVals++;
            for (AdjNode adjNode : adjList[curr]) {
                incomingCount[adjNode.vertex]--;
                if (incomingCount[adjNode.vertex] == 0)
                    queue.add(adjNode.vertex);
            }
        }
        if (totalVals != v) {
            System.out.println("Above data is wrong, the graph is not a DAG");
        }
    }

}
