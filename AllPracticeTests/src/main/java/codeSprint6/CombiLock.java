package codeSprint6;

import java.util.Scanner;

/**
 * Created by pparth on 8/28/16.
 */
public class CombiLock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        int a, modVal;
        int total=0;
        for(int i=0;i<5;i++) {
            arr[i] = in.nextInt();
        }

        for(int i=0;i<5;i++) {
            a = in.nextInt();
            modVal = Math.abs(arr[i] - a);
            if(modVal <= 5) {
                total+=modVal;
            } else {
                total+=(9-modVal+1);
            }
        }
        System.out.print(total);
    }
}
