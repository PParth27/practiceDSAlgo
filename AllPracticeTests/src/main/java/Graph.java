
import java.util.*;
class Graph
{
    private int numVertex;
    private int[] specialVertices;
    private int[][] adjMatrix;

    Graph(int v)
    {
        this.numVertex = v;
        adjMatrix = new int[v][v];
        for(int i=0;i<v;i++) {
            for(int j=0;j<v;j++) {
                if(i!=j) {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public int getNumVertex() {
        return numVertex;
    }

    public void setNumVertex(int numVertex) {
        this.numVertex = numVertex;
    }

    public int[] getSpecialVertices() {
        return specialVertices;
    }

    public void setSpecialVertices(int[] specialVertices) {
        this.specialVertices = specialVertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    void addEdge(int v, int w, int weight)
    {
        adjMatrix[v][w] =  weight;
        adjMatrix[w][v] = weight;
    }

    /*
    void BFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        for (Integer abc : adj[v]) {
            int n = abc;
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    */

    int BFS(int v)
    {
        boolean visited[ ] = new boolean[numVertex];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;
        long length = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
        }
        return 0;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int numV = in.nextInt();
        int numE = in.nextInt();
        Graph graph = new Graph(numV);

        for(int i=1;i <= numE;i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int wt = in.nextInt();
            graph.addEdge(from, to, wt);
        }

        int numSpecial = in.nextInt();
        int[] specialArray = new int[numSpecial];
        for(int i=0;i<numSpecial;i++) {
            specialArray[i] = in.nextInt();
        }
        for(int i = 1;i<numV;i++) {
            System.out.println(graph.BFS(i));
        }
    }
}