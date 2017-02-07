package blackRock;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 6/12/16.
 */
public class EmployeeStock {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] rating = new int[n+1];
        int[] minStocks = new int[n+1];
        int[] vals = new int[n+1];
        for(int i=1;i<n+1;i++) {
            rating[i] = in.nextInt();
        }
        for(int i=1;i<n+1;i++) {
            minStocks[i] = in.nextInt();
        }
        for(int i = 1;i<=n;i++) {
            vals[i] = minStocks[i];
            Map<Integer, Integer> ratingToStocks = new HashMap<>();
            ratingToStocks.put(rating[i], vals[i]);
            int j = i-1;
            while (j>=1) {
                
                j--;
            }
        }
    }
}
