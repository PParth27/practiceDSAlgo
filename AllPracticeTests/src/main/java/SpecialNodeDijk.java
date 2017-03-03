import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 4/28/16.
 */
public class SpecialNodeDijk {

    static class myComparator implements Comparator<NodeDis> {

        public int compare(NodeDis o1, NodeDis o2) {
            return o1.dis - o2.dis;
        }
    }

    static class NodeDis {

        int v;
        int dis;

        public NodeDis(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numV = in.nextInt();
        long[][] adjMatrix = new long[numV + 1][numV + 1];
        for (int i = 1; i <= numV; i++) {
            for (int j = 1; j <= numV; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int numE = in.nextInt();
        for (int i = 0; i < numE; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int wt = in.nextInt();
            adjMatrix[v1][v2] = wt;
            adjMatrix[v2][v1] = wt;
        }
        int numS = in.nextInt();
        List<Integer> special = new ArrayList<>();
        for (int i = 0; i < numS; i++) {
            special.add(in.nextInt());
        }
        PriorityQueue<NodeDis> pq = new PriorityQueue<NodeDis>(numV, new myComparator());
        for(int i=1;i<=numV;i++) {
            final Integer label = i;
            pq.offer(new NodeDis(i, (special.stream().anyMatch(x -> x == label)) ? 0 : Integer.MAX_VALUE));
        }
        int[] finalArray = new int[numV+1];
        while (!pq.isEmpty()) {
            NodeDis current = pq.poll();
            finalArray[current.v] = current.dis;
            for(int i=1;i<numV;i++) {

            }
        }

    }
}
