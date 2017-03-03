package RandomQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 9/6/16.
 */
public class RichieRich {
    public static void main(String[] arrgs) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        String value = in.next();
        char[] val = value.toCharArray();
        List<Integer> changed = new ArrayList<>();
        if(n==1) {
            if(k>0) {
                System.out.print(9);
                return;
            }
        }
        for(int i=0, j=n-1;i<=j;i++,j--) {
            if(val[i] != val[j]) {
                if(k>0) {
                    if(val[i] > val[j]) {
                        val[j] = val[i];
                    } else {
                        val[i] = val[j];
                    }
                    k--;
                    changed.add(i);
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int i = 0;
        while (k>=1 && i<n) {
            if(k==1 && n%2 == 1 && i==n/2) {
                val[i] = '9';
            }
            if(changed.contains(i) && val[i] != '9') {
                val[i] = '9';
                val[n - i - 1] = '9';
                k--;
            } else {
                if(k>1) {
                    if (val[i] != '9') {
                        val[i] = '9';
                        val[n - i - 1] = '9';
                        k -= 2;
                    }
                }
            }
            i++;
        }
        System.out.print(val);
    }
}
