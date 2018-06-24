import parth.pranav.graph.GraphBasics.AdjGraph;

public class RunGraphLogic {

    public static void main(String[] jj) {
        int v = 8, e = 10;
        AdjGraph adjGraph = new AdjGraph(v, e);
        adjGraph.addEdgeUndirected(0, 1, 44);
        adjGraph.addEdgeUndirected(1, 2, 4);
        adjGraph.addEdgeUndirected(2, 3, 32);
        adjGraph.addEdgeUndirected(3, 4, 45);
        adjGraph.addEdgeUndirected(7, 6, 21);
        adjGraph.addEdgeUndirected(6, 3, 7);
        adjGraph.addEdgeUndirected(5, 1, 12);
        adjGraph.addEdgeUndirected(6, 4, 9);
        adjGraph.addEdgeUndirected(2, 7, 12);
        adjGraph.addEdgeUndirected(7, 1, 43);

        //DAG :
        int v1 = 5, e1 = 5;
        AdjGraph adjGraph1 = new AdjGraph(v1, e1);
        adjGraph1.addEdgeDirected(0, 1, 44);
        adjGraph1.addEdgeDirected(1, 3, 44);
        adjGraph1.addEdgeDirected(2, 3, 44);
        adjGraph1.addEdgeDirected(3, 4, 44);
        adjGraph1.addEdgeDirected(0, 4, 44);


        System.out.println("DFS :");
        adjGraph1.printUsingDFS(0, new int[v+1]);
        System.out.println("BFS :");
        //adjGraph1.printUsingBFS(0);
        System.out.println("TOPOLOGICAL SORT : ");
        adjGraph1.printTopologicalSort();
    }
}
