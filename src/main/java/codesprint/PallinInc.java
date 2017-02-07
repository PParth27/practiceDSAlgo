package codesprint;

import java.util.Scanner;

/**
 * Created by pparth on 5/22/16.
 */
public class PallinInc {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        int minChanges = 0;
        boolean[] changed = new boolean[n];
        char[] num = number.toCharArray();
        for(int i=0, j=n-1;i<=j;i++, j--) {
            if(num[i] != num[j]) {
                if(num[i] - '0' > num[j] - '0') {
                    num[j] = num[i];
                } else {
                    num[i] = num[j];
                }
                changed[i] = true;
                minChanges++;
            }
        }

        if (k - minChanges < 0) {
            System.out.print(-1);
        } else if(k == minChanges) {
            System.out.print(num);
        } else {
            int left = k - minChanges;
            for(int i=0,j=n-1;i<=j && left>0;i++,j--) {
                if(changed[i] || (i==j)) {
                    if(num[i] != '9') {
                        num[i] = '9';
                        num[j] = '9';
                        left -= 1;
                    }
                } else {
                    if(left>=2) {
                        if(num[i] != '9') {
                            num[i] = '9';
                            num[j] = '9';
                            left -= 2;
                        }
                    }
                }
            }
            System.out.print(num);
        }
    }
}
