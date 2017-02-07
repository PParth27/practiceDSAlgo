package weekOfcode25;

import java.util.Scanner;

/**
 * Created by pparth on 11/1/16.
 */
public class AppendDelete {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] hj) {
        Scanner in = getScanner();
        String ini = in.next();
        String end = in.next();
        int k =in.nextInt();
        //int start = Math.max(ini.length(), end.length());
        int start = ini.length();
        int i = start;
        int curr = i;
        while (i>0) {
            i--;
            if(i>=ini.length() || i>=end.length() || ini.charAt(i) != end.charAt(i)) {
                curr = i;
            }
        }
        int toBeRemoved = start-curr;
        int left = k-toBeRemoved;
        if(left<0) {
            System.out.print("No");
        } else if ( left - (end.length()-curr) > 0 && (left - (end.length()-curr)) % 2 == 0){
            System.out.print("Yes");
        } else {
            if(left >= end.length()-curr + 2*(start-toBeRemoved)) {
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }
        }






//        if(ini.length() < end.length()) {
//            boolean flag = false;
//            int i = start;
//            int curr = i;
//            while (i>0) {
//                i--;
//                if(i>=ini.length() || i>=end.length() || ini.charAt(i) != end.charAt(i)) {
//                    curr = i;
//                }
//            }
//            int left = start - curr;
//
//            if(k-left == end.length()-curr) {
//                System.out.print("Yes");
//            } else {
//                if(k-left >= end.length()-curr + 2*(start-left)) {
//                    System.out.print("Yes");
//                } else {
//                    System.out.print("No");
//                }
//            }
//        } else if(ini.length() == end.length()) {
//            int i = start;
//            int curr = i;
//            while (i>0) {
//                i--;
//                if(i>=ini.length() || i>=end.length() || ini.charAt(i) != end.charAt(i)) {
//                    curr = i;
//                }
//            }
//            int left = start - curr;
//            if(k-left == left) {
//                System.out.print("Yes");
//            } else {
//                if(k-left >= left + 2*(start-left)) {
//                    System.out.print("Yes");
//                } else {
//                    System.out.print("No");
//                }
//            }
//
//        } else {
//            boolean flag = false;
//            int i = start;
//            int curr = i;
//            while (i>0) {
//                i--;
//                if(i>=ini.length() || i>=end.length() || ini.charAt(i) != end.charAt(i)) {
//                    curr = i;
//                }
//            }
//            int left = start - curr;
//
//            if(k-left == end.length()-curr) {
//                System.out.print("Yes");
//            } else {
//                if(k-left >= end.length()-curr + 2*(ini.length()-left)) {
//                    System.out.print("Yes");
//                } else {
//                    System.out.print("No");
//                }
//            }
//        }
    }
}
