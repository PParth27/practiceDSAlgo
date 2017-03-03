package CodeSprint4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 6/25/16.
 */
public class MinDistances {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int arr[] = new int[n];
        int curr, min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for(int i=0; i < n; i++){
            curr = in.nextInt();
            List<Integer> thisList = pos.get(curr);
            if(thisList == null) {
                List current = new ArrayList<>();
                current.add(i);
                pos.put(curr, current);
            } else {
                for(Integer val : thisList) {
                    min = Math.min(min, Math.abs(i - val));
                }
                thisList.add(i);
                pos.put(curr, thisList);
            }
        }
        System.out.print((min == Integer.MAX_VALUE) ? -1 : min);
    }
}
