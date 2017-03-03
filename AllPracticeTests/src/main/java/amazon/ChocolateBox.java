package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 7/9/16.
 */
public class ChocolateBox {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        Map<Integer, Integer> lookup = new HashMap<>(1000001);
        int j = 1, initJ = 1;
        for(int i=1;i<=n;i++) {
            int choNum = in.nextInt();
            while (j<=choNum+initJ-1) {
                lookup.put(j, i);
                j++;
            }
            initJ = j;
        }
        int q = in.nextInt();

        for(int i=0;i<q;i++) {
            System.out.println(lookup.get(in.nextInt()));
        }
    }
}
