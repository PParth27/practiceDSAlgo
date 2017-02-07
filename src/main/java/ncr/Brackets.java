package ncr;

import java.util.Scanner;

/**
 * Created by pparth on 11/6/16.
 */
public class Brackets {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    public static long count;
    public static long modu = 1000000007;
    static char[] str;

    public static void goGoGo(int pos, int n, int open, int close, int k) {
        if(close == n/2) {
            int checkK = 0;
            for(int i=0;i<str.length-1;i++) {
                if(str[i] != str[i+1])
                    checkK++;
            }
            if(checkK >= k)
                count = (count+1) % modu;
            return;
        } else {
            if(open > close) {
                str[pos] = ')';
                goGoGo(pos+1, n, open, close+1, k);
            }
            if(open<n/2) {
                str[pos] = '(';
                goGoGo(pos+1, n,open+1,close,k);
            }
        }

    }

    public static void findParanCount(int n, int k) {
        if(n>0)
            goGoGo(0, n, 0, 0, k);
    }

    public static void main(String[] po) {
        Scanner in = getScanner();
        int q = in.nextInt();

        while(q>0) {
            int n = in.nextInt();
            int k = in.nextInt();
            count = 0;
            str = new char[n];
            findParanCount(n,k);
            System.out.println(count);
            q--;
        }
    }
}
