package Hack101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by pparth on 8/29/16.
 */
public class NextTopoMine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int from, to;

        List<Integer>[] graph = new ArrayList[n+1];

        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        TreeSet<Integer> currSet = new TreeSet<>();
        int[] numIncoming = new int[n+1];
        int[] numIncoming2 = new int[n+1];
        for(int i = 0;i<m;i++) {
            from = in.nextInt();
            to = in.nextInt();
            graph[from].add(to);
            numIncoming[to]++;
            numIncoming2[to]++;
        }
        for(int i=1;i<=n;i++) {
            if(numIncoming[i] == 0)
                currSet.add(i);
        }

        int[] topoGiven = new int[n+1];

        for(int i=1;i<=n;i++) {
            topoGiven[i] = in.nextInt();
        }

        int pos=1;
        int indexChange = -1;

        while (!currSet.isEmpty()) {
            if(currSet.last() != topoGiven[pos]) {
                indexChange = pos;
            }
            currSet.remove(topoGiven[pos]);
            for(Integer vertex : graph[topoGiven[pos]]) {
                numIncoming[vertex]--;
                if(numIncoming[vertex] == 0)
                    currSet.add(vertex);
            }
            pos++;
        }
        for(int i=1;i<=n;i++) {
            if(numIncoming2[i] == 0)
                currSet.add(i);
        }
        if(indexChange == -1) {
            System.out.println("-1");
        } else {
            pos = 1;
            int val;
            while (!currSet.isEmpty()) {
                val = -1;
                if (pos == indexChange) {
                    val = currSet.higher(topoGiven[pos]);
                } else if (pos < indexChange) {
                    val = topoGiven[pos];
                } else {
                    val = currSet.first();
                }
                System.out.print(val + " ");
                currSet.remove(val);
                for (Integer vertex : graph[val]) {
                    numIncoming2[vertex]--;
                    if (numIncoming2[vertex] == 0)
                        currSet.add(vertex);
                }
                pos++;
            }
            System.out.print("\n");
        }
    }
}
