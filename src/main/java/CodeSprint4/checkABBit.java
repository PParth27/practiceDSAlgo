package CodeSprint4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 6/26/16.
 */
public class checkABBit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for(int aa=0;aa<q;aa++) {
            int k = in.nextInt();

            int a = Integer.parseInt(in.next(), 16);
            int b = Integer.parseInt(in.next(), 16);
            int c = Integer.parseInt(in.next(), 16);


            int iniDiff = (a | b) ^ c;
            List<Integer> diffs = new ArrayList<>();

            int position = 0;
            while(iniDiff > 0) {
                if((iniDiff & 1) == 1) {
                    diffs.add(position);
                }
                iniDiff >>= 1;
                position++;
            }
            int count = 0, fA = a, fB = b;
            for(int pos : diffs) {
                int a1=a,b1=b;
                int aBit = (a1>>pos) & 1;
                int bBit = (b1>>pos) & 1;
                if((aBit | bBit) == 0) {
                    count++;
                    fB = fB | (1 << pos);
                } else {
                    if(bBit == 1 && aBit == 1) {
                        count+=2;
                        fA = fA & (~1 << pos);
                        fB = fB & (~1 << pos);
                    } else {
                        count++;
                        if(bBit == 1) {
                            fB = fB & (~(1 << pos));
                        } else {
                            fA = fA & (~(1 << pos));
                        }
                    }
                }
            }
            if(count <= k) {
                System.out.println(Integer.toHexString(fA).toUpperCase() + "\n" + Integer.toHexString(fB).toUpperCase());
            } else {
                System.out.println(-1);
            }
        }
    }
}
