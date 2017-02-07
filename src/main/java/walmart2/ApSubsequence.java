package walmart2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 10/30/16.
 */
public class ApSubsequence {
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

    public static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static final BigInteger moduB = BigInteger.valueOf(1000000009);

    static BigInteger binomial(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = (((ret.mod(moduB).multiply(BigInteger.valueOf(N-k)).mod(moduB)).mod(moduB)
                    .divide(BigInteger.valueOf(k+1).mod(moduB))).mod(moduB)).mod(moduB);
        }
        return ret;
    }

    public static void main(String[] iy) {
        Scanner in = getScanner();
        int n = in.nextInt();
        int[] arr = getArrayOneStart(in, n);
        Map<Integer, List<Pair>> map = new HashMap<>();
        for(int i=1;i<=n;i++) {
            for(int j = i+1; j<=n;j++) {
                Pair pair = new Pair(i,j);
                int key = arr[j] - arr[i];
                if(map.get(key) != null) {
                    map.get(key).add(pair);
                } else {
                    List<Pair> curr = new ArrayList<>();
                    curr.add(pair);
                    map.put(key, curr);
                }
            }
        }
        BigInteger ans = BigInteger.valueOf(n+1).mod(moduB);
        ans = (ans.mod(moduB).add(binomial(n, 2)).mod(moduB)).mod(moduB);
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            List<Pair> pairs = entry.getValue();
            int[] lengths = new int[n+1];
            for(Pair pair : pairs) {
                lengths[pair.j] = lengths[pair.i]+1;
            }
            for(int i=1;i<=n;i++) {
                if(lengths[i] > 1) {
                    int k = lengths[i];
                    ans = (ans.mod(moduB).add(BigInteger.valueOf(k-1).mod(moduB))).mod(moduB);

                }
            }
        }
        System.out.print(ans);
    }
}
