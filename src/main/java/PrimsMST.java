import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 5/14/16.
 */
public class PrimsMST {

    public static class NodeDi {
        int v;
        int dis;
        public NodeDi(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
        @Override
        public boolean equals(Object anObject) {
            if(this == anObject) {
                return true;
            }
            if(!(anObject instanceof NodeDi)) {
                return false;
            }
            NodeDi nodeDi = (NodeDi) anObject;
            if(nodeDi.v != this.v) {
                return false;
            }
            return true;
        }
        @Override
        public int hashCode() {
            return v;
        }
    }
    public static int nodes;
    public static int edges;
    public static LinkedList<NodeDi>[] adj;
    public static int[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        adj = new LinkedList[nodes+1];
        visited = new int[nodes +1];
        PriorityQueue<NodeDi> priorityQueue = new PriorityQueue<>(nodes + 1, (NodeDi a, NodeDi b) -> a.dis - b.dis);
        for(int i=0;i<edges;i++) {
            int a,b,wt;
            a = in.nextInt();
            b = in.nextInt();
            wt = in.nextInt();
            if(adj[a] == null) {
                adj[a] = new LinkedList<>();
            }
            if(adj[b] == null) {
                adj[b] = new LinkedList<>();
            }

            NodeDi aa = new NodeDi(b, wt);
            NodeDi bb = new NodeDi(a,wt);
            int indA = adj[a].indexOf(aa);
            int indB = adj[b].indexOf(bb);
            if(indA != -1) {
                wt = Math.min(wt, adj[a].get(indA).dis);
                adj[a].remove(indA);
                adj[b].remove(indB);
            }
            adj[a].add(aa);
            adj[b].add(bb);
        }
        int start = in.nextInt();
        for(int i=1;i<=nodes;i++) {
            if(i == start) {
                priorityQueue.add(new NodeDi(i, 0));
            } else{
                priorityQueue.add(new NodeDi(i, Integer.MAX_VALUE));
            }
        }
        int sum = 0;
        while(!priorityQueue.isEmpty()) {
            NodeDi curr = priorityQueue.poll();
            sum+=curr.dis;
            visited[curr.v] = 1;
            for(Object obj : priorityQueue.toArray()) {
                NodeDi node = (NodeDi) obj;
                int index = adj[curr.v].indexOf(node);
                NodeDi inAdj = (index != -1) ? adj[curr.v].get(index) : null;
                if(inAdj != null && node.dis > inAdj.dis) {
                    priorityQueue.remove(node);
                    node.dis = inAdj.dis;
                    priorityQueue.add(node);
                }
            }
        }
        System.out.print(sum);
    }
}
