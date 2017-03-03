package CodeSprint7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pparth on 9/25/16.
 */
public class Metro {

    public static class Interval {
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] jsnfj) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        final BigInteger[] ans = { BigInteger.valueOf(n).multiply(BigInteger.valueOf(m)) };
        Map<Integer, List<Interval>> done = new HashMap<>();
        while(k>0) {
            int row = in.nextInt();
            int start = in.nextInt();
            int end = in.nextInt();
            Interval currInt = new Interval(start, end);
            List<Interval> earlierTrain = done.get(row);
            if(earlierTrain == null) {
                done.put(row, new ArrayList<>());
                done.get(row).add(currInt);
            } else {
                done.get(row).add(currInt);
            }
            k--;
        }
        done.forEach((key, value) -> {
            Collections.sort(value, (a,b) -> a.start - b.start);
            Stack<Interval> stack = new Stack<>();
            stack.add(value.get(0));
            value.remove(0);
            value.forEach((val) -> {
                if(stack.peek().end >= val.start && stack.peek().end < val.end) {
                    stack.push(new Interval(stack.pop().start, val.end));
                } else if (stack.peek().end >= val.start && stack.peek().end >= val.end) {
                } else {
                    stack.push(val);
                }
            });
            while(!stack.isEmpty()) {
                Interval curr = stack.pop();
                ans[0] = ans[0].subtract(BigInteger.valueOf(curr.end).subtract(
                        BigInteger.valueOf(curr.start)).add(BigInteger
                        .ONE));
            }
        });
        System.out.println(ans[0]);
    }
}
