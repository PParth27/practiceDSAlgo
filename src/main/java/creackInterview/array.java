package creackInterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by pparth on 10/2/16.
 */
public class array {
    public static Queue<Integer> arrayLeftRotation(Queue<Integer> a, int n, int k) {
        k%=n;
        while (k>0) {
            a.add(a.poll());
            k--;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Queue<Integer> a = new LinkedList<>();
        for(int a_i=0; a_i < n; a_i++){
            a.add(in.nextInt());
        }

        Queue<Integer> output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output.poll() + " ");
        System.out.println();

    }
}
