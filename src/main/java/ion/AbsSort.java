package ion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by pparth on 11/20/16.
 */
public class AbsSort {
    public static void main(String[] yt) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Integer[] arr = new Integer[n];

        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, ((o1, o2) -> Math.abs(o1) - Math.abs(o2)));

        for(int i=0;i<n;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
