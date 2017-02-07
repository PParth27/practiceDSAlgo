package RandomQuestions;

import java.util.Scanner;

/**
 * Created by pparth on 8/19/16.
 */
public class AlmostSorted {

    private static boolean isSorted(int[] arr) {
        for(int i = 1; i<arr.length - 1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
    private static boolean swapAndCheck(int i, int j, int[] arr) {
        int[] arr2 = arr.clone();
        int temp;
        temp = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp;
        if(isSorted(arr2)) {
            return true;
        }
        return false;
    }
    private static boolean reverseAndCheck(int l, int r, int[] arr) {
        int[] arr2 = arr.clone();
        int temp;
        for(int i = l, j=r;i<=j;i++,j--) {
            if(arr2[i] < arr2[j]) {
                return false;
            } else {
                temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
            }
        }
        if(isSorted(arr2)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n+1];

        for(int i = 1;i<=n;i++) {
            arr[i] = in.nextInt();
        }
        if(isSorted(arr)) {
            System.out.println("yes");
        } else {
          for(int i=1;i<n;i++) {
              for(int j=i+1;j<=n;j++) {
                  if(arr[i]>arr[j]) {
                      if(swapAndCheck(i,j, arr)) {
                          System.out.println("yes");
                          System.out.println("swap " + i + " " + j);
                          return;
                      } else if(reverseAndCheck(i,j, arr)) {
                          System.out.println("yes");
                          System.out.println("reverse " + i + " " + j);
                          return;
                      }
                  }
              }
          }
          System.out.println("no");
        }
    }
}
