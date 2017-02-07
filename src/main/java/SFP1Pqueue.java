import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by pparth on 5/8/16.
 */
public class SFP1Pqueue {

    public static class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static int[] getJoinedPipes(int[] input1, int input2) {
        if (input1.length != input2)
            return null;
        int outputSize = (input2 == 1) ? 1 : input2 - 1;
        int[] output = new int[outputSize];
        if (input2 == 1) {
            output[0] = 0;
        } else if (input2 == 2) {
            output[0] = input1[0] + input1[1];
        } else {
            PriorityQueue<Integer> priorityQueue =
                    new PriorityQueue<>(input2, new MinComparator());
            for(int i = 0; i < input2;i++) {
                priorityQueue.add(input1[i]);
            }
            for(int i = 0 ; i < outputSize;i++) {
                output[i] = priorityQueue.poll() + priorityQueue.poll();
                priorityQueue.add(output[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] lengths = {2,3,5,6,7,8};
        int size = 6;
        System.out.print(Arrays.toString(getJoinedPipes(lengths, size)));
    }
}
