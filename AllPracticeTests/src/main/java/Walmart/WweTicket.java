package Walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 8/21/16.
 */
public class WweTicket {

    public static long count = 0L;
    public static long[][] edgeWeights;
    public static int[] edgePairs;
    public static class Edge {
        int from;
        int to;
        long wt;

        public Edge(int from, int to, long wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    public static void countMembers(int leaf, int root) {
        int curr = leaf;
        long val;
        long leftover = 0L;
        while(curr != root) {
            count+=leftover;
            int to = edgePairs[curr];
            val = (edgeWeights[curr][to])*2 + 1;
            count+=val;
            leftover = val;
            curr = to;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        Long wt;
        int nodes = in.nextInt();

        edgeWeights = new long[nodes+1][nodes+1];
        edgePairs = new int[nodes+1];
        int edges = in.nextInt();
        int root = nodes;
        int[] findRoot = new int[nodes+1];
        int[] findLeaves = new int[nodes+1];
        long[] minDis = new long[nodes + 1];
        Edge[] allEdges = new Edge[nodes + 1];
        for (int i = 1; i <= edges; i++) {
            a = in.nextInt();
            findRoot[a] = 1;
            b = in.nextInt();
            findLeaves[b] = 1;
            wt = in.nextLong();
            allEdges[i] = new Edge(b, a, wt);
            edgeWeights[a][b] = wt;
            edgePairs[a] = b;
        }
        List<Integer> leaves = new ArrayList<>();

        for(int i=1;i<=nodes;i++) {
            if(findLeaves[i] == 0) {
                leaves.add(i);
            }
            if(findRoot[i] == 0) {
                root = i;
            }
        }

        for(int i=1;i<=nodes;i++) {
            minDis[i] = Long.MAX_VALUE;
        }

        long absoluteMin = Long.MAX_VALUE;
        minDis[root] = 0L;
        for (int i=1;i<nodes;i++) {
            for (int j=1;j<=edges;j++) {
                Edge curr = allEdges[j];
                if(minDis[curr.from] != Long.MAX_VALUE && minDis[curr.to] > minDis[curr.from] + curr.wt) {
                    minDis[curr.to] = minDis[curr.from] + curr.wt;
                }
                if(minDis[curr.to] != Long.MAX_VALUE && minDis[curr.from] > minDis[curr.to] + curr.wt) {
                    minDis[curr.from] = minDis[curr.to] + curr.wt;
                }
            }
        }
        for(Integer leaf : leaves) {
            if(absoluteMin > minDis[leaf]) {
                absoluteMin = minDis[leaf];
            }
        }
        int anyLeaf = -1;
        for(Integer leaf : leaves) {
            if(minDis[leaf] != absoluteMin)
                continue;
            if(anyLeaf == -1) {
                if(minDis[leaf] == absoluteMin) {
                    anyLeaf = leaf;
                    countMembers(anyLeaf, root);
                    System.out.println(count);
                }
            }
            int curr = leaf;
            while(true) {
                if(curr != root) {
                    System.out.print(curr + " -> ");
                } else {
                    System.out.print(curr);
                    break;
                }
                curr = edgePairs[curr];
            }
            System.out.print("\n");
        }
    }
}
