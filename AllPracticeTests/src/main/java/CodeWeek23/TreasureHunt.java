package CodeWeek23;

import java.util.Scanner;

/**
 * Created by pparth on 9/16/16.
 */
public class TreasureHunt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        double y = in.nextDouble();

        double a = in.nextDouble();
        double b = in.nextDouble();
        double ax = a*x;
        double by = b*y;
        double ay = a * y;
        double xb = x*b;
        //double ab2 = 2*a*b;
        double asbs = a*a + b*b;


        System.out.println((ax + by)/(asbs));
        System.out.println((ay - xb)/(asbs));
    }
}
