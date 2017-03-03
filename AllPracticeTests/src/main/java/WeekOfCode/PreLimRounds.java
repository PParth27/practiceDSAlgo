package WeekOfCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 7/1/16.
 */
public class PreLimRounds {

    static class myComparator implements Comparator<Long> {

        public int compare(Long o1, Long o2) {
            return (int) (o2 - o1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>(n, new myComparator());
        long val, req;
        long sumFin = 0;
        for(int i=0;i<n;i++) {
            val = in.nextLong();
            req = in.nextLong();
            if(req == 0) {
                sumFin+=val;
            } else {
                pq.add(val);
            }
        }
        while(k>0) {
            sumFin+=pq.poll();
            k--;
        }
        while (!pq.isEmpty()) {
            sumFin-=pq.poll();
        }
        System.out.print(sumFin);
    }
}
