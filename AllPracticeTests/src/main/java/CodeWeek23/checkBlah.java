package CodeWeek23;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 * Created by pparth on 9/20/16.
 */
public class checkBlah {

    private static class ChildWithDis {
        int node;
        int dis;
        public ChildWithDis(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    private static List<Integer>[] adj;
    private static Set<ChildWithDis>[] allChildren;
    private static int[] visited;
    private static int distanceToFind;
    private static boolean flag;
    private static void dfs(int node, int prevDis, int find) {
        if(!flag) {
            if (visited[node] == 0) {
                visited[node] = 1;
                if (node == find) {
                    distanceToFind = prevDis + 1;
                    flag = true;
                }
                for (Integer nei : adj[node]) {
                    dfs(nei, prevDis + 1, find);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a;
        adj = new ArrayList[n+1];
        allChildren = new HashSet[n+1];
        int[] parentRel = new int[n+1];
        for(int i=1;i<=n;i++) {
            adj[i] = new ArrayList<>();
            allChildren[i] = new HashSet<ChildWithDis>();
        }
        for(int i=1;i<n;i++)
            parentRel[i] = in.nextInt();

        //Add to adj list and enter values in all children list;
        for(int i=1;i<n;i++) {
            a = parentRel[i];
            adj[a].add(i+1);
            adj[i+1].add(a);
            allChildren[a].add(new ChildWithDis(i+1, 1));
            int k = a;
            int count = 2;
            while(k>0) {
                k = parentRel[k-1];
                if(k<=0)
                    break;
                allChildren[k].add(new ChildWithDis(i+1, count));
                count++;
            }
        }
        int q = in.nextInt();

        while(q>0) {
            int start = in.nextInt();
            int find = in.nextInt();
            distanceToFind = 0;
            visited = new int[n+1];
            flag = false;
            boolean childFlag = false;
            long sum = 0;
            dfs(start, -1, find);
            sum += distanceToFind * distanceToFind;
            for(ChildWithDis curr : allChildren[find]) {
                if(curr.node == start) {
                    childFlag = true;
                }
                sum+=(distanceToFind+curr.dis) * (distanceToFind+curr.dis);
            }
            if(childFlag) {
                for(ChildWithDis curr : allChildren[start]) {
                    sum -= (distanceToFind + distanceToFind) * (distanceToFind + distanceToFind) + 2 *
                            (distanceToFind + distanceToFind) * curr.dis;
                }
                sum-=(distanceToFind + distanceToFind) * (distanceToFind + distanceToFind);
            }
            System.out.println(sum);
            q--;
        }
    }
}
