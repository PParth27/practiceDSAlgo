
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pparth on 4/28/16.
 */
public class TestPriorityQueue {

    static class myComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(10, new myComparator());
        pq1.offer(287);
        pq1.offer(43);
        pq1.offer(23);
        pq1.offer(1);
        pq1.offer(87);
        pq1.offer(445);
        pq1.offer(76);
        pq1.offer(224);
        pq1.offer(890);
        pq1.offer(0);
        for(int i =0 ;i<10;i++) {
            System.out.println(pq1.poll());
        }
    }
}
