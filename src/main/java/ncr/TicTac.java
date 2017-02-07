package ncr;

import java.util.Scanner;

/**
 * Created by pparth on 11/6/16.
 */
public class TicTac {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] io) {
        Scanner in = getScanner();
        int q = in.nextInt();

        while(q>0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            char[][] arr = new char[n+1][m+1];

            for(int i=0;i<n;i++) {
                String curr = in.next();
                for(int j = 0;j<m;j++) {
                    arr[i][j] = curr.charAt(j);
                }
            }
            boolean isX = false;
            boolean isO = false;
            int it,count, jt;
            for(int i=0;i<n;i++) {
                for(int j = 0;j<m;j++) {
                    char val = arr[i][j];
                    if(isO && val == 'O')
                        continue;
                    if(isX && val == 'X')
                        continue;
                    if(val == '-')
                        continue;
                    //hori
                    if(!(m-j < k)) {
                        it = j;
                        count = 0;
                        for (; count < k && it < m; it++) {
                            if (arr[i][it] != val) {
                                break;
                            } else {
                                count++;
                            }
                        }
                        if (count == k) {
                            if (val == 'X')
                                isX = true;
                            if (val == 'O')
                                isO = true;
                            continue;
                        }
                    }

                    if(!(n-i < k)) {
                        //verti
                        it = i;
                        count = 0;
                        for (; count < k && it < n; it++) {
                            if (arr[it][j] != val) {
                                break;
                            } else {
                                count++;
                            }
                        }
                        if (count == k) {
                            if (val == 'X')
                                isX = true;
                            if (val == 'O')
                                isO = true;
                            continue;
                        }
                    }
                    if(!(Math.min(n-i , m-j) < k)) {
                        //diaRight
                        it = i;
                        jt = j;
                        count = 0;
                        for (; count < k && it < n && jt < m; it++, jt++) {
                            if (arr[it][jt] != val) {
                                break;
                            } else {
                                count++;
                            }
                        }
                        if (count == k) {
                            if (val == 'X')
                                isX = true;
                            if (val == 'O')
                                isO = true;
                            continue;
                        }
                    }
                    if(!(Math.min(n-i, j+1) < k)) {
                        //diaLeft
                        it = i;
                        jt = j;
                        count = 0;
                        for (; count < k && it < n && jt >= 0; it++, jt--) {
                            if (arr[it][jt] != val) {
                                break;
                            } else {
                                count++;
                            }
                        }
                        if (count == k) {
                            if (val == 'X')
                                isX = true;
                            if (val == 'O')
                                isO = true;
                            continue;
                        }
                    }
                }
            }
            if(isX && !isO) {
                System.out.println("LOSE");
            } else if(isO && !isX) {
                System.out.println("WIN");
            } else {
                System.out.println("NONE");
            }
            q--;
        }
    }
}
