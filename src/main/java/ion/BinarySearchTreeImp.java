package ion;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pparth on 11/20/16.
 */
public class BinarySearchTreeImp {

    public static class TreeNode {
        int key;
        int childNum;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key, int childNum, TreeNode left, TreeNode right) {
            this.childNum = childNum;
            this.key = key;
            this.left=left;
            this.right=right;
        }
    }

    public static void main(String[] po) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Integer[] monk = new Integer[n];
        Integer[] nMonk = new Integer[m];

        for(int i = 0;i<n;i++) {
            monk[i] = in.nextInt();
        }
        for(int i = 0;i<n;i++) {
            nMonk[i] = in.nextInt();
        }
        Arrays.sort(monk);
        Arrays.sort(nMonk);

        BigInteger vMonk = BigInteger.ZERO;
        BigInteger vNMonk = BigInteger.ZERO;

        for(int i =0;i<n;i++) {
            int curr = monk[i];
            int fI = 0;
            int gI = 0;

            int index = Arrays.binarySearch(nMonk, curr);
            if(index < 0) {
                index = Math.abs(index+1);
                if(index == m) {
                    fI = m;
                    gI = 0;
                } else {
                    fI = index;
                    gI = m-fI;
                }
            } else {

            }
            for(int j=0;j<m;j++) {
                if(nMonk[j] > curr) {
                    if(fI == 0)
                        fI = j;
                    gI = m-j;
                    break;
                } else if(nMonk[j] == curr) {
                    fI = j;
                }
            }
            vMonk = vMonk.add(BigInteger.valueOf(fI*gI));
        }

        for(int i =0;i<m;i++) {
            int curr = nMonk[i];
            int fI = 0;
            int gI = 0;
            for(int j=0;j<n;j++) {
                if(monk[j] > curr) {
                    if(fI == 0)
                        fI = j;
                    gI = m-j;
                    break;
                } else if(monk[j] == curr) {
                    fI = j;
                }
            }
            vNMonk = vNMonk.add(BigInteger.valueOf(fI*gI));
        }
        BigInteger diff = vMonk.subtract(vNMonk);
        if(diff.compareTo(BigInteger.ZERO) == 1) {
            System.out.print("Monk " + diff);
        } else if(diff.compareTo(BigInteger.ZERO) == -1) {
            System.out.print("!Monk " + diff.abs());
        } else {
            System.out.print("Tie");
        }
    }
}
