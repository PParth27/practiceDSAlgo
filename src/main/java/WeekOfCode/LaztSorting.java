package WeekOfCode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 7/1/16.
 */
public class LaztSorting {

    public static boolean isSorted(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger factorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return fact;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
            Integer vl = map.get(arr[i]);
            if(vl == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], vl+1);
            }
        }
        if(isSorted(arr)) {
            System.out.print("0.000000");
        } else {
            BigInteger maxFact = factorial(n);
            for(Map.Entry entry : map.entrySet()) {
                maxFact = maxFact.divide(factorial((Integer)entry.getValue()));
            }
            System.out.print(maxFact.toString() + ".000000");
        }
    }
}
