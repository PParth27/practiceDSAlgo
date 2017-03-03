package CodeSprint7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 9/25/16.
 */
public class Metro2 {
    public static void main(String[] jsnfj) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BigInteger total = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
        int k = in.nextInt();
        Map<Integer, List<Integer>> done = new HashMap<>();
        while(k>0) {
            int row = in.nextInt();
            int start = in.nextInt();
            int end = in.nextInt();
            List<Integer> earlierTrain = done.get(row);
            if(earlierTrain == null) {
                done.put(row, new ArrayList<>());
                List<Integer> vv = done.get(row);
                for(int i=start;i<=end;i++) {
                    vv.add(i);
                }
                done.put(row, vv);
                total = total.subtract(BigInteger.valueOf(end).subtract(BigInteger.valueOf(start)).add(BigInteger.ONE));
            } else {
                for(int i=start;i<=end;i++) {
                    if(!earlierTrain.contains(i)) {
                        total = total.subtract(BigInteger.ONE);
                        earlierTrain.add(i);
                    }
                }
                done.put(row, earlierTrain);
            }
            k--;
        }
        System.out.println(total);
    }
}
