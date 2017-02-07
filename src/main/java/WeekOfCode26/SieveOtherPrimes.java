package WeekOfCode26;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 11/30/16.
 */
public class SieveOtherPrimes {
    public static void main(String[] po) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> allPrimes = new ArrayList<>();
        int[] finalPrimes = new int[1000001];
        int ansCount = 0;
        allPrimes.add(2);
        if(2 >= n)
            finalPrimes[ansCount++] = 2;
        int i = 3;
        boolean shouldAdd = false;
        while(i<=m) {
            shouldAdd = true;
            for(Integer curr : allPrimes) {
                if(i%curr == 0) {
                    shouldAdd = false;
                    break;
                }
            }
            if(shouldAdd) {
                allPrimes.add(i);
                if (i >= n)
                    finalPrimes[ansCount++] = i;
            }
            i++;
        }

        int ans =0;
        for (int j=0;j<ansCount;j++) {
            if(finalPrimes[j+1] - finalPrimes[j] == 2)
                ans++;
        }
        System.out.print(ans);
    }
}
