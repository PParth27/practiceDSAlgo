import java.io.Console;
import java.util.*;

/**
 * Created by pparth on 5/7/16.
 */
public class DijkMinDis {

    public static Long[][] adj;
    public static Integer start;
    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (int) (adj[start][o1] - adj[start][o2]);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a, b;
        Long wt;
        for (int xx = 0; xx < t; xx++) {
            int nodes = in.nextInt();
            int edges = in.nextInt();
            Long[] minDis = new Long[nodes + 1];
            adj = new Long[nodes + 1][nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                for (int j = 1; j <= nodes; j++) {
                    adj[i][j] = (i != j) ? 10000000 : 0L;
                }
            }
            for (int i = 0; i < edges; i++) {
                a = in.nextInt();
                b = in.nextInt();
                wt = in.nextLong();
                if (wt < adj[a][b])
                    adj[a][b] = wt;
                if (wt < adj[b][a])
                    adj[b][a] = wt;
            }
            start = in.nextInt();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nodes + 1, new MyComparator());
            for (int i = 1; i <= nodes; i++) {
                priorityQueue.add(i);
            }
            while (!priorityQueue.isEmpty()) {
                Integer curr = priorityQueue.poll();
                minDis[curr] = adj[start][curr];
                for (int i = 1; i <= nodes; i++) {
                    Long aaa = adj[start][curr] + adj[curr][i];
                    if (aaa < adj[start][i]) {
                        priorityQueue.remove(i);
                        adj[start][i] = aaa;
                        adj[i][start] = aaa;
                        priorityQueue.add(i);
                    }
                }
            }
            for (int i = 1; i <= nodes; i++) {
                if (i != start) {
                    System.out.print((minDis[i] != 10000000) ? minDis[i] + " ": -1 + " ");
                }
            }
            System.out.print("\n");
        }
    }
}
