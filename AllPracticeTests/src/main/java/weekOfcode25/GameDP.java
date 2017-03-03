package weekOfcode25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 11/3/16.
 */
public class GameDP {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<Long> arr;
    public static long n;
    public static int m;
    public static Map<Long, Boolean> memo;

    public static boolean checkIfWin(long n) {
        boolean noDiv = true;
        boolean answer = false;
        Boolean memoisedAns = memo.get(n);
        if(memoisedAns != null) {
            return memo.get(n);
        } else {
            for (long curr : arr) {
                long div = n / curr;
                if (n % curr == 0) {
                    answer = answer || !checkIfWin(div);
                    noDiv = false;
                }
            }
            if (noDiv) {
                memo.put(n, false);
                return false;
            } else {
                memo.put(n, answer);
                return answer;
            }
        }
    }

    public static void main(String[] dff) {
        Scanner in = getScanner();
        n = in.nextLong();
        m = in.nextInt();
        arr = new ArrayList<>();
        memo = new HashMap<>();
        for(int i=0;i<m;i++) {
            long a = in.nextLong();
            if(n%a==0) {
                arr.add(a);
            }

        }
        if(checkIfWin(n)) {
            System.out.print("First");
        } else {
            System.out.print("Second");
        }
    }
}
