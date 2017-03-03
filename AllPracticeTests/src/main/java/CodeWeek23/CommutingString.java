package CodeWeek23;

import java.util.Scanner;

/**
 * Created by pparth on 9/17/16.
 */
public class CommutingString {
    public static void main(String[] main) {
        Scanner in = new Scanner(System.in);
        long modu = 1000000007;
        char[] s = in.next().toCharArray();
        int len = s.length;
        long m = in.nextLong();
        char v = s[0];
        boolean flag = true;
        for(int i=1;i<len;i++) {
            if(s[i] != v) {
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println(m%modu);
            return;
        }
        int i=0, j=1;
        int currLen = -1;
        while(j<len) {
            if(s[i] != s[j]) {
                i = 0;
                j+=1;
                currLen=j-i;
            } else {
                i+=1;
                j+=1;
            }
        }
        if(len%currLen == 0) {
            System.out.println((m / (long) currLen) % modu);
        } else {
            System.out.println((m / (long) len) % modu);
        }
    }
}
