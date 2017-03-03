package WeekOfCode26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 11/30/16.
 */
public class SievePrimes {

    public static int[] primes;
    public static int primeLen;
    public static int sieveLen;
    public static List<Integer> lastArray;
    public static int n,m;

    public static void main(String[] po) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        primes = new int[m - n + 1];
        primeLen = 0;
        sieveLen = (int) Math.sqrt(m);
        lastArray = new ArrayList<>();
        int start = 2;
        int end = start + sieveLen - 1;
        while (end <= m) {
            updatePrimes(start, end);
            start = end + 1;
            end = start + sieveLen - 1;
        }

        int ans = 0;
        for (int j = 0; j < primeLen; j++) {
            if (primes[j + 1] - primes[j] == 2)
                ans++;
        }
        System.out.print(ans);
    }

    public static void updatePrimes(int start, int end) {
        int[] hashCheckPrime = new int[sieveLen];
        for(Integer curr: lastArray) {
            int count = 2;
            int mul = curr * count;
            while (mul <= end) {
                if(mul > start)
                    hashCheckPrime[mul - start] = 1;
                count++;
                mul = curr * count;
            }
        }
        lastArray = new ArrayList<>();
        int i = start;
        while(i<=end) {
            if(i >= n) {
                primes[primeLen++] = i;
            }
            lastArray.add(i);
            int count = 2;
            int mul = i*count;
            while(mul<=end) {
                hashCheckPrime[mul-start] = 1;
                count++;
                mul = i*count;
            }
            i++;
            while (true) {
                if(i<=end && hashCheckPrime[i-start] != 0)
                    i++;
                else
                    break;
            }
        }
    }
}
