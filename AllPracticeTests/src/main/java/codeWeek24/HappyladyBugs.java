package codeWeek24;

import java.util.Scanner;

/**
 * Created by pparth on 10/11/16.
 */
public class HappyladyBugs {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static boolean isHappy(String str) {
        char[] curr = str.toCharArray();
        int n = curr.length;
        for(int i=0;i<n;i++) {
            if(i==0) {
                if(i+1 < n && curr[i] != curr[i+1]) {
                    return false;
                }
            }
            if(i==n-1) {
                if(i-1>=0 && curr[i-1] != curr[i])
                    return false;
            }
            if(i+1 < n && i-1>=0 && curr[i] != curr[i-1] && curr[i] != curr[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] sdj) {
        Scanner in = getScanner();

        int g = in.nextInt();
        while(g>0) {
            int[] num = new int[27];
            int underNum = 0;
            int n = in.nextInt();
            String curr = in.next();
            if(curr.length() == 1) {
                if(curr.charAt(0) != '_') {
                    System.out.println("NO");
                    g--;
                    continue;
                } else {
                    System.out.println("YES");
                    g--;
                    continue;
                }
            }
            if(isHappy(curr))
                System.out.println("YES");
            else {
                char[] str = curr.toCharArray();
                int l = str.length;
                for(int i=0;i<l;i++) {
                    if(str[i] == '_') {
                        underNum++;
                    } else {
                        num[str[i] - 'A']++;
                    }
                }
                if(underNum>0) {
                    boolean flag = false;
                    for(int i = 0;i<num.length;i++) {
                        if(num[i] == 1) {
                            System.out.println("NO");
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                        System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            g--;
        }
    }
}
