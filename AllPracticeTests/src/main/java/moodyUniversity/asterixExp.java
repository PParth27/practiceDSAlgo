package moodyUniversity;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pparth on 9/29/16.
 */
public class asterixExp {

    public static BigInteger modexp(BigInteger a, BigInteger b, BigInteger n) {
        if (b.compareTo(new BigInteger("0")) == 0) return new BigInteger("1");
        BigInteger t = modexp(a, b.divide(new BigInteger("2")), n);  // use long for intermediate computations to eliminate
        // overflow
        BigInteger c = (t.multiply(t)).mod(n);
        if (b.mod(new BigInteger("2")).compareTo(new BigInteger("1")) == 0)
            c = (c.multiply(a)).mod(n);
        return c;
    }

    public static void main(String [] agdh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean flag = false;
        while(t>0) {
            flag = false;
            String thisIsIt = in.next();
            char[] input = thisIsIt.toCharArray();
            BigInteger left, modu = new BigInteger("1000000007");
            boolean isPow;
            BigInteger right;
            int ini;
            int k =2;
            while(k>0) {
                String sLeft = "";int i=0;
                while (i< input.length && input[i] != '*') {
                    if(sLeft.length() == 0 && input[i] == '0') {
                        System.out.println("Syntax Error");
                        flag = true;
                        break;
                    }
                    if(input[i] - '0' < 0 || input[i] - '0' > 9) {
                        System.out.println("Syntax Error");
                        flag = true;
                        break;
                    }
                    sLeft += input[i];
                    i++;
                }
                if(flag)
                    break;
                if (sLeft.equals("")) {
                    System.out.println("Syntax Error");
                    flag = true;
                    break;
                }
                ini = 0;
                for (; i < input.length;) {
                    String sRight = "";
                    int count = 0;
                    while (i< input.length && input[i] == '*') {
                        if(count > 2) {
                            System.out.println("Syntax Error");
                            flag = true;
                            break;
                        }
                        count++;
                        i++;
                    }
                    if (count == 0) {
                        System.out.println("Syntax Error");
                        flag = true;
                        break;
                    }
                    isPow = (count == 2);
                    while (i< input.length && input[i] != '*') {
                        if(sRight.length() == 0 && input[i] == '0') {
                            System.out.println("Syntax Error");
                            flag = true;
                            break;
                        }
                        if(input[i] - '0' < 0 || input[i] - '0' > 9) {
                            System.out.println("Syntax Error");
                            flag = true;
                            break;
                        }
                        sRight += input[i];
                        i++;
                    }
                    if (flag)
                        break;
                    if (sRight.equals("")) {
                        System.out.println("Syntax Error");
                        flag = true;
                        break;
                    }
                    if(isPow && k==2) {
                        left = new BigInteger(sLeft);
                        right = new BigInteger(sRight);
                        BigInteger val = modexp(left,right,modu);
                        String addedVal = String.valueOf(val);
                        thisIsIt = thisIsIt.substring(0, ini) + addedVal + thisIsIt.substring(i, thisIsIt
                                .length());
                        i = ini + addedVal.length();
                        sLeft = addedVal;
                    } else if(!isPow && k == 1) {
                        left = new BigInteger(sLeft);
                        right = new BigInteger(sRight);
                        BigInteger val = ((left).multiply(right));
                        String addedVal = String.valueOf(val);
                        thisIsIt = thisIsIt.substring(0, ini) + addedVal + thisIsIt.substring(i, thisIsIt
                                .length());
                        i = ini + addedVal.length();
                        sLeft = addedVal;
                    } else {
                        sLeft = sRight;
                        ini = i - 1;
                    }
                    input = thisIsIt.toCharArray();
                }
                if(flag)
                    break;
                k--;
            }
            if(!flag)
                System.out.println(new BigInteger(thisIsIt));
            t--;
        }
    }
}
