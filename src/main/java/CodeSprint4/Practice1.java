package CodeSprint4;

/**
 * Created by pparth on 6/25/16.
 */

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice1 {

    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);
        Map<Integer, List<Integer>> vals = new HashMap<>(n);
        int[] where = new int[n];
        for(int i = 1; i <= I; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            if(where[a] != 0) {
                vals.get(where[a]).add(b);
                where[b] = where[a];
            } else if(where[b] != 0) {
                vals.get(where[b]).add(a);
                where[a] = where[b];
            }else {
                List curr1 = new ArrayList<>();
                curr1.add(a);
                curr1.add(b);
                vals.put(i , curr1);
                where[a]=i;
                where[b]=i;
            }
            // Store a and b in an appropriate data structure of your choice
        }

        BigInteger combinations = binomial(n, 2);
        for(int i=0;i<n;i++) {
            if(vals.get(i) != null) {
                if (vals.get(i).size() > 1) {
                    combinations = combinations.subtract(binomial(vals.get(i).size(), 2));
                }
            }
        }
        // Compute the final answer - the number of combinations

        System.out.println(combinations);

    }
}
