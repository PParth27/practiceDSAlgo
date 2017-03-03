package pracDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 6/21/16.
 */
public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] coins = new int[m+1];
        int[] dpArray = new int[n+1];
        for(int i=1;i<=m;i++) {
            coins[i] = in.nextInt();
        }
        int count, findVal;
        List<Integer> done;
        for(int i=1;i<=n;i++) {
            count = 0;
            done = new ArrayList<>();
            for(int j=1;j<=i;j++) {
                if (i == j) {
                    findVal = i;
                    for(int k=1;k<=m;k++) {
                        if(coins[k] == findVal) {
                            count++;
                            break;
                        }
                    }
                } else {
                    findVal = i - j;
                    if(!done.contains(j)) {
                        count += dpArray[findVal];
                        done.add(findVal);
                    }
                }
            }
            dpArray[i] = count;
        }
        System.out.print(Arrays.toString(dpArray));
    }
}
