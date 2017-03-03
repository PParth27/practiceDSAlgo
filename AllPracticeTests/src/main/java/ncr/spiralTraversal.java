package ncr;

import java.util.Scanner;

/**
 * Created by pparth on 11/5/16.
 */
public class spiralTraversal {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] kj) {
        Scanner in = getScanner();
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] arr = new char[n+1][m+1];


        for(int i=0;i<n;i++) {
            String curr = in.next();
            for(int j=0;j<m;j++) {
                arr[i][j] = curr.charAt(j);
            }
        }
        int lowLimI = 0;
        int lowLimJ = 0;
        int i = n-1;
        int j = 0;
        char[] ans = new char[m*n+1];
        int k=0;
        boolean flag;
        while(i>=lowLimI && i<n && j>=lowLimJ && j<m) {
            flag = false;
            for(;i>=lowLimI;i--) {
                ans[k++] = arr[i][j];
                flag = true;
            }
            lowLimJ++;
            i++;
            j++;
            if(!flag)
                break;
            flag = false;
            for(;j<m;j++) {
                ans[k++] = arr[i][j];
                flag = true;
            }
            lowLimI++;
            j--;
            i++;
            if(!flag)
                break;
            flag = false;
            for(;i<n;i++) {
                ans[k++] = arr[i][j];
                flag = true;
            }
            m--;
            i--;
            j--;
            if(!flag)
                break;
            flag = false;
            for(;j>=lowLimJ;j--) {
                ans[k++] = arr[i][j];
                flag = true;
            }
            n--;
            j++;
            i--;
            if(!flag)
                break;
        }
        int count = 0;
        for(int ii = 0;ii<k;) {

            while (ii<k && ans[ii] == '#'){
                ii++;
            }
            if(ii>=k)
                break;
            else
                count++;
            while (ii<k && ans[ii] != '#') {
                ii++;
            }
        }
        System.out.print(count);
    }
}
