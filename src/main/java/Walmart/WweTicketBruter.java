package Walmart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 8/21/16.
 */
public class WweTicketBruter {
    public static long[][] edgeWeights;
    public static int[] edgePairs;


    public static class PairNodes {
        List<Integer> children;

        public void addChild(int child) {
            children.add(child);
        }
    }

    public static PairNodes[] childGroup;

    public static long countMembers(int leaf, int root) {
        long count = 0L;
        int curr = leaf;
        long val;
        long leftover = 0L;
        while(curr != root) {
            count+=leftover;
            int to = edgePairs[curr];
            int sibling = curr;
            List<Integer> children = childGroup[to].children;
            for(Integer child : children) {
                if(child!=curr) {
                    sibling = child;
                    break;
                }
            }
            if(edgeWeights[curr][to] < edgeWeights[sibling][to]) {
                val = (edgeWeights[curr][to] * 2) + 1;
            } else if(edgeWeights[curr][to] > edgeWeights[sibling][to]) {
                val = (edgeWeights[sibling][to] * 2) + 1;
            } else {
                val = (edgeWeights[curr][to] * 2);
            }
            count+=val;
            leftover = val;
            curr = to;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        Long wt;
        int nodes = in.nextInt();
        childGroup = new PairNodes[nodes+1];
        edgeWeights = new long[nodes + 1][nodes + 1];
        edgePairs = new int[nodes + 1];
        int edges = in.nextInt();
        int root = nodes;
        int[] findRoot = new int[nodes + 1];
        int[] findLeaves = new int[nodes + 1];
        for (int i = 1; i <= edges; i++) {
            a = in.nextInt();
            findRoot[a] = 1;
            b = in.nextInt();
            findLeaves[b] = 1;
            wt = in.nextLong();
            edgeWeights[a][b] = wt;
            edgePairs[a] = b;
            if(childGroup[b] == null) {
                childGroup[b] = new PairNodes();
                childGroup[b].children = new ArrayList<>();
                childGroup[b].addChild(a);
            } else {
                childGroup[b].addChild(a);
            }
        }
        List<Integer> leaves = new ArrayList<>();

        for (int i = 1; i <= nodes; i++) {
            if (findLeaves[i] == 0) {
                leaves.add(i);
            }
            if (findRoot[i] == 0) {
                root = i;
            }
        }

        long absoluteMin = Long.MAX_VALUE;
        long[] disFromLeaves = new long[nodes + 1];
        long currDis;
        for (Integer leaf : leaves) {
            currDis = countMembers(leaf, root);
            disFromLeaves[leaf] = currDis;
            if (currDis < absoluteMin) {
                absoluteMin = currDis;
            }
        }
        System.out.println(absoluteMin);

        for (Integer leaf : leaves) {
            if (disFromLeaves[leaf] == absoluteMin) {
                int curr = leaf;
                while (true) {
                    if (curr != root) {
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
}

