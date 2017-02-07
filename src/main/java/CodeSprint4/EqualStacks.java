package CodeSprint4;

import java.util.Scanner;

/**
 * Created by pparth on 6/25/16.
 */
public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1,n2,n3;
        n1 = in.nextInt();
        n2 = in.nextInt();
        n3 = in.nextInt();
        int i1=1,i2=1,i3=1;
        int arr1[] = new int[n1+1];
        int arr2[] = new int[n2+1];
        int arr3[] = new int[n3+1];
        long sum1=0,sum2=0,sum3=0;
        for(int i=1;i<=n1;i++) {
            arr1[i] = in.nextInt();
            sum1+=arr1[i];
        }
        for(int i=1;i<=n2;i++) {
            arr2[i] = in.nextInt();
            sum2+=arr2[i];
        }
        for(int i=1;i<=n3;i++) {
            arr3[i] = in.nextInt();
            sum3+=arr3[i];
        }

        while(!(sum1 == sum2 && sum2 == sum3)) {
            long max = Math.max(sum1, Math.max(sum2,sum3));
            if(max == sum1) {
                sum1 = sum1 - arr1[i1];
                i1++;
            }
            if(max == sum2) {
                sum2 = sum2 - arr2[i2];
                i2++;
            }
            if(max == sum3) {
                sum3 = sum3 - arr3[i3];
                i3++;
            }
        }
        System.out.print(sum1);
    }
}
