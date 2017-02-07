package Nzoo;

import java.util.Scanner;

class PrimePrime {

    public static boolean isPrime(int n) {
        if (n == 2)
            return true;
        if (n == 3)
            return true;
        if (n % 2 == 0)
            return false;
        if (n % 3 == 0)
            return false;
        int i = 5;
        int w = 2;

        while (i * i <= n) {
            if (n % i == 0)
                return false;
            i += w;
            w = 6 - w;
        }
        return true;
    }

    public static boolean isPrimePrime(int val) {
        int primeCount = val-1;

        boolean[] containsPrime = new boolean[val+1];

        for(int i=2;i<=val;i++) {
            if(!containsPrime[i]) {
                int j=2;
                int k = i*2;
                while (k<=val) {
                    if(!containsPrime[k]) {
                        containsPrime[k] = true;
                        primeCount--;
                    }
                    j++;
                    k = i*j;
                }
            }
        }
        return isPrime(primeCount);
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int k=0;k<t;k++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int count=0;
            for(int i=l;i<=r;i++) {
                if(isPrimePrime(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}


