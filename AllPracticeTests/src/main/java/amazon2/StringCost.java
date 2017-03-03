package amazon2;

import java.util.Scanner;

/**
 * Created by pparth on 10/23/16.
 */
public class StringCost {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] er) {
        Scanner in = getScanner();

        int t= in.nextInt();
        while (t>0) {
            char[] s = in.next().toCharArray();
            int len = s.length;
            int i=0, j=1;
            int currLen = 1;
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
            if(len%currLen == 0 && currLen < len) {
                System.out.println(currLen);
            } else {
                System.out.println(len);
            }
            t--;
        }
    }
}
