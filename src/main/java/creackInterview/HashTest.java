package creackInterview;

import MyClasses.ScannerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 10/3/16.
 */
public class HashTest {
    public static void main(String [] h) {
        Scanner in = ScannerUtil.getScanner();
        int n = in.nextInt();
        int m =in.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            String val = in.next();
            if(!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val)+1);
            }
        }
        for(int i=0;i<m;i++) {
            String val = in.next();
            int num = map.get(val);
            if(num < 0) {
                System.out.print("No");
                return;
            } else {
                map.put(val, num-1);
            }
        }
        System.out.print("Yes");
    }
}
