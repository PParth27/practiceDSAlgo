package Hack101;

import java.util.Scanner;

/**
 * Created by pparth on 8/23/16.
 */
public class Letter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h[] = new int[27];
        for(int i=1; i < 27; i++){
            h[i] = in.nextInt();
        }
        String word = in.next();
        int maxHt = Integer.MIN_VALUE, ht;
        for(char a : word.toCharArray()) {
            ht = h[(int)a - 96];
            if(ht>maxHt)
                maxHt = ht;
        }
        System.out.print(word.length() * maxHt);
    }
}
