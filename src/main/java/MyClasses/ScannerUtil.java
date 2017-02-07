package MyClasses;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by pparth on 10/3/16.
 */
public class ScannerUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static int[] getArrayOneStart(Scanner in, int size) {
        int[] arr = new int[size+1];
        for(int i=1;i<=size;i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    /**
     * Get a graph as adj list input.
     */
    static LinkedList<Integer>[] adj;
    static boolean[] isVisited;
    static int nodes;
    static int edges;

    public static void inputAdjGraph(Scanner in) {
        nodes = in.nextInt();
        edges = in.nextInt();

        adj = new LinkedList[nodes+1];
        isVisited = new boolean[nodes+1];
        for(int i=1;i<=nodes;i++) {
            adj[i] = new LinkedList<>();
        }

        for(int i=0;i<edges;i++) {
            adj[in.nextInt()].add(in.nextInt());
        }
    }
    //Graph done
}
