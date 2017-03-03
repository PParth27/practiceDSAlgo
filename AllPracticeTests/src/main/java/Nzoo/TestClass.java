package Nzoo;

import java.util.Scanner;
class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] input = new String[n+1];
        for(int i=1;i<=n;i++) {
            input[i] = in.next();
        }
        long maxGen = 0;
        long[] maxDays = new long[n+1];
        long maxDay = 0;
        long currGen = 0;
        long currDay = 0;
        for(int j=1;j<=n;j++) {
            char[] currString = input[j].toCharArray();
            for (int i = 0; i < currString.length; i++) {
                if (currString[i] == 'C') {
                    currGen++;
                    currDay++;
                } else {
                    if (currGen > maxGen) {
                        maxGen = currGen;
                    }
                    if (currDay > maxDays[j]) {
                        maxDays[j] = currDay;
                    }
                    currGen = 0;
                    currDay = 0;
                }
            }
            maxDays[j] = currDay;
            currDay = 0;
            if(maxDays[j] > maxDay) {
                maxDay = maxDays[j];
            }
        }
        if (currGen > maxGen) {
            maxGen = currGen;
        }
        System.out.print(maxDay + " " + maxGen);
    }
}
