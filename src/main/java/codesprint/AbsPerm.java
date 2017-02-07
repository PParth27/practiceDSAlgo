package codesprint;

import java.util.Scanner;

/**
 * Created by pparth on 5/22/16.
 */
public class AbsPerm {
    public static int n;
    public static int k;
    public static int absPerm(int i, int[] number, int[] checker) {
        int[] number2 = number.clone();
        int[] checker2 = checker.clone();
        if(i > n) {
            for(int jj = 1 ; jj<number.length;jj++) {
                System.out.print(number[jj] + " ");
            }
            System.out.print("\n");
            return 1;
        }
        if(i-k <= 0 && i+k > n) {
            return 0;
        } else {
            if (i-k <= 0 && i+k <= n) {
                if(checker[i+k] == 0) {
                    number2[i] = i + k;
                    checker2[i + k] = 1;
                    return absPerm(i + 1, number2, checker2);
                } else {
                    return 0;
                }
            } else if (i-k > 0 && i+k > n) {
                if(checker[i-k] == 0) {
                    number2[i] = i - k;
                    checker2[i - k] = 1;
                    return absPerm(i + 1, number2, checker2);
                } else {
                    return 0;
                }
            } else {
                //lower
                if(checker[i-k] == 0) {
                    number2[i] = i-k;
                    number2[i] = i - k;
                    checker2[i - k] = 1;
                    int val = absPerm(i + 1, number2, checker2);
                    if(val == 1) {
                        return 1;
                    }
                } else if (checker[i+k] == 0){
                    number2[i] = i+k;
                    number2[i] = i + k;
                    checker2[i + k] = 1;
                    int val = absPerm(i + 1, number2, checker2);
                    if(val == 1) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int tt=0;tt<t;tt++) {
            n = in.nextInt();
            k=in.nextInt();
            int[] checker = new int[n+1];
            int[] number = new int[n+1];
            if(absPerm(1, number, checker) == 0) {
                System.out.println(-1);
            }
        }
    }
}
