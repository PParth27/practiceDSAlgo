import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by pparth on 5/7/16.
 */
public class BfsMinCuts {

    public static class WithPath {
        List<Integer> path;
        int val;
        public WithPath(List<Integer> path, int val) {
            this.path = path;
            this.val = val;
        }
    }
    static LinkedList<Integer>[] adj;
    static boolean[] isVisited;
    public static int getMinCuts(String[] edges) {
        adj = new LinkedList[500];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < edges.length; i++) {
            String[] both = edges[i].split("#");
            int a = Integer.parseInt(both[0]);
            int b = Integer.parseInt(both[1]);
            if(a<min) {
                min = a;
            }
            if(a > max) {
                max = a;
            }
            if(b<min) {
                min = b;
            }
            if(b > max) {
                max = b;
            }
            if (adj[a] == null) {
                adj[a] = new LinkedList<>();
            }
            if (adj[b] == null) {
                adj[b] = new LinkedList<>();
            }
            adj[a].add(b);
            adj[b].add(a);
        }
        int counter = 0;
        while (true) {
            boolean found = false;
            isVisited = new boolean[max + 1];
            Queue<WithPath> queue = new LinkedList<>();
            queue.add(new WithPath(new ArrayList<>(), min));
            isVisited[min] = true;
            WithPath curr = null;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                if (curr.val == max) {
                    curr.path.add(max);
                    found = true;
                    break;
                }
                List<Integer> updatedPath = new ArrayList<>(curr.path);
                updatedPath.add(curr.val);
                for (int value : adj[curr.val]) {
                    if (!isVisited[value]) {
                        isVisited[value] = true;
                        queue.add(new WithPath(updatedPath, value));
                    }
                }
            }
            if (curr != null && found) {
                counter++;
                for(int i = 0;i<curr.path.size() - 1;i++) {
                    adj[curr.path.get(i)].remove(adj[curr.path.get(i)].indexOf(curr.path.get(i+1)));
                    adj[curr.path.get(i+1)].remove(adj[curr.path.get(i+1)].indexOf(curr.path.get(i)));
                }
            } else {
                break;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        String input[ ] = {"1#2", "1#5", "2#5", "2#3", "3#4", "3#6", "4#5", "4#6"};
        System.out.print(getMinCuts(input));
    }
}
