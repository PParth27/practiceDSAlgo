package WeekOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pparth on 7/1/16.
 */
public class FindN {

    static Map<Integer, Pair> points;

    public static class Pair {
        int x;
        int y;

        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean areOnOppositeSide(int main1, int main2, int left, int right) {
        Pair leftPair = points.get(left);
        Pair rightPair = points.get(right);
        Pair pair1 = points.get(main1);
        Pair pair2 = points.get(main2);
        if(pair2.y - pair1.y == 0) {
            double leftVal = (leftPair.y - pair1.y);
            double rightVal = (rightPair.y - pair1.y);
            if((leftVal > 0 && rightVal < 0) || (leftVal < 0 && rightVal > 0)) {
                return true;
            }
            return false;
        }
        double leftVal = (((leftPair.y - pair1.y) * (pair2.x - pair1.x)) / (pair2.y - pair1.y)) + pair1.x - leftPair.x;
        double rightVal = (((rightPair.y - pair1.y) * (pair2.x - pair1.x)) / (pair2.y - pair1.y)) + pair1.x - rightPair.x;
        if((leftVal > 0 && rightVal < 0) || (leftVal < 0 && rightVal > 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        points = new HashMap<>(n+1);
        for(int i=1;i<=n;i++) {
            points.put(i, new Pair(in.nextInt(), in.nextInt()));
        }
        long counter = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(j==i) {
                    continue;
                }
                for(int k=1;k<=n;k++) {
                    if(k==i||k==j) {
                        continue;
                    }
                    for(int l=1;l<=n;l++) {
                        if(l==i||l==j||l==k) {
                            continue;
                        }
                        if(areOnOppositeSide(i,j,k,l)) {
                            counter++;
                        }
                    }
                }
            }
        }
        System.out.print(counter);
    }
}
