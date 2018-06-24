package parth.pranav.graph.GraphBasics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

public class Test {

    public static void main(String[] pp) {
        List<StubCountCombination> aa = new ArrayList<>();
        aa.add(new StubCountCombination(UUID.randomUUID(), 5));
        aa.add(new StubCountCombination(UUID.randomUUID(), 10));
        aa.add(new StubCountCombination(UUID.randomUUID(), 2));
        aa.add(new StubCountCombination(UUID.randomUUID(), 1));
        aa.add(new StubCountCombination(UUID.randomUUID(), 1));
        List<List<UUID>> output = getOptimalBatchSize(aa, 9);
    }


    public static List<List<UUID>> getOptimalBatchSize(List<StubCountCombination> listOfCount, Integer batchsize) {

        List<List<UUID>> multiList = new ArrayList<>();
        PriorityQueue<StubCountCombination> pq = new PriorityQueue<StubCountCombination>(
                listOfCount.size(), (lhs, rhs) -> rhs.getCount() - lhs.getCount());
        pq.addAll(listOfCount);

        while (!pq.isEmpty()) {
            Integer remaining = batchsize;
            if (pq.peek().getCount() >= batchsize) {
                List<UUID> list = new ArrayList<>();
                list.add(pq.peek().getId());
                multiList.add(list);
                pq.poll();
            } else {
                List<UUID> mList = new ArrayList<>();
                mList.add(pq.peek().getId());
                remaining -= pq.peek().getCount();
                pq.remove(pq.peek());
                PriorityQueue<StubCountCombination> pqr = new PriorityQueue<StubCountCombination>(
                        listOfCount.size(), new Comparator<StubCountCombination>() {
                    public int compare(StubCountCombination lhs, StubCountCombination rhs) {
                        return rhs.getCount() - lhs.getCount();
                    }
                });
                pqr.addAll(pq);
                while (!pqr.isEmpty() && remaining > 0) {
                    Integer rem = pqr.peek().getCount();
                    if (remaining - rem > 0) {
                        mList.add(pqr.peek().getId());
                        pq.remove(pqr.peek());
                        remaining -= rem;
                    }
                    pqr.poll();
                }
                multiList.add(mList);
            }
        }
        LinkedHashMap

        return multiList;
    }
}
