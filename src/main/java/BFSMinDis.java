import java.util.*;
public class BFSMinDis {

    public static class Node {
        int val;
        Long dis;

        public Node(int val, Long dis) {
            this.dis = dis;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int xx = 0;xx<t;xx++) {
            int a, b;
            int nodes = in.nextInt();
            int edges = in.nextInt();
            LinkedList<Integer>[] adj = new LinkedList[nodes + 1];
            if(nodes < 0) {
                continue;
            }
            boolean[] isVisited = new boolean[nodes + 1];
            Long[] minDis = new Long[nodes + 1];
            for (int i = 0; i < edges; i++) {
                a = in.nextInt();
                b = in.nextInt();
                if (adj[a] == null) {
                    adj[a] = new LinkedList<>();
                }
                if (adj[b] == null) {
                    adj[b] = new LinkedList<>();
                }
                adj[a].add(b);
                adj[b].add(a);
            }
            int start = in.nextInt();
            isVisited[start] = true;
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(start, 0L));

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                minDis[curr.val] = curr.dis;
                if(adj[curr.val] != null) {
                    for (int next : adj[curr.val]) {
                        if (!isVisited[next]) {
                            isVisited[next] = true;
                            queue.add(new Node(next, curr.dis + 6));
                        }
                    }
                }
            }
            for(int i = 1;i<minDis.length;i++) {
                if(i != start)
                    System.out.print((minDis[i] != null) ? minDis[i] + " " : -1 + " ");
            }
            System.out.print("\n");
        }

    }
}