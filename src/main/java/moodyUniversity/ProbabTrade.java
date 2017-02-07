package moodyUniversity;

import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by pparth on 9/29/16.
 */
public class ProbabTrade {
    public static void main(String[] kjndsf) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k =in.nextInt();

        double[] chance = new double[n+1];
        double[] profit = new double[n+1];
        double[] loss = new double[n+1];

        for(int i=0;i<n;i++) {
            chance[i] = in.nextDouble();
        }
        for(int i=0;i<n;i++) {
            profit[i] = in.nextDouble();
        }
        for(int i=0;i<n;i++) {
            loss[i] = in.nextDouble();
        }

        PriorityQueue<Double> yoyo = new PriorityQueue<>(n+1, (Double a, Double b) ->  (b > a) ? 1 : -1);

        for(int i=0;i<n;i++) {
            Double ans = chance[i] * profit[i] - (1 - chance[i]) * loss[i];
            yoyo.add(ans);
        }
        Double sum = 0.0;
        for(int i=0;i<k;i++) {
            if(yoyo.peek() > 0) {
                sum+=yoyo.poll();
            }
        }
        //DecimalFormat aa = new DecimalFormat("0.00");
        System.out.printf("%.2f", sum);
    }
}
