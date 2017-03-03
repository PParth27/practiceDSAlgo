package CodeSprint4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pparth on 6/26/16.
 */
public class ABBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for(int aa=0;aa<q;aa++) {
            int k = in.nextInt();

            BigInteger a = new BigInteger(in.next(), 16);
            BigInteger b = new BigInteger(in.next(), 16);
            BigInteger c = new BigInteger(in.next(), 16);

            BigInteger inter = a.or(b);
            BigInteger iniDiff = inter.xor(c);
            List<Integer> diffs = new ArrayList<>();

            int position = 0;
            while(iniDiff.compareTo(BigInteger.valueOf(0)) > 0) {
                if((iniDiff.and(BigInteger.valueOf(1)).equals(BigInteger.valueOf(1)))) {
                    diffs.add(position);
                }
                position++;
                iniDiff = iniDiff.shiftRight(1);
            }
            long count = 0;
            BigInteger fA = a, fB = b;
            for(int pos : diffs) {
                BigInteger aBit = (a.shiftRight(pos)).and(BigInteger.valueOf(1));
                BigInteger bBit = (b.shiftRight(pos)).and(BigInteger.valueOf(1));
                if((aBit.or(bBit)).equals(BigInteger.valueOf(0))) {
                    count++;
                    fB = fB.setBit(pos);
                } else {
                    if(bBit.equals(BigInteger.valueOf(1)) && aBit.equals(BigInteger.valueOf(1))) {
                        count+=2;
                        fA = fA.clearBit(pos);
                        fB = fB.clearBit(pos);
                    } else {
                        count++;
                        if(bBit.equals(BigInteger.valueOf(1))) {
                            fB = fB.clearBit(pos);
                        } else {
                            fA = fA.clearBit(pos);
                        }
                    }
                }
            }
            if(count <= k) {
                System.out.println(fA.toString(16).toUpperCase() + "\n" + fB.toString(16).toUpperCase());
            } else {
                System.out.println(-1);
            }
        }
    }
}
