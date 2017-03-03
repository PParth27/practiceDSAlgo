package RandomQuestions;

import java.util.Scanner;

/**
 * Created by pparth on 9/7/16.
 */
public class Dna {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String dn = in.next();
        char[] dna = dn.toCharArray();

        int[] number = new int[4];

        for(char aa : dna) {
            if(aa == 'A')
                number[0]++;
            else if(aa == 'C')
                number[1]++;
            else if(aa == 'T')
                number[2]++;
            else
                number[3]++;
        }
        int allLen = n/4;
        int[] needed = new int[4];
        int minNeeded =0;
        if(number[0] > allLen) {
            minNeeded += (number[0] - allLen);
            needed[0] = number[0] - allLen;
        }
        if(number[1] > allLen) {
            minNeeded += (number[1] - allLen);
            needed[1] = number[1] - allLen;
        }
        if(number[2] > allLen) {
            minNeeded += (number[2] - allLen);
            needed[2] = number[2] - allLen;
        }
        if(number[3] > allLen) {
            minNeeded += (number[3] - allLen);
            needed[3] = number[3] - allLen;
        }
        int i=0,j=0;
        int[] currNum = new int[4];
        int minCount = Integer.MAX_VALUE;
        if (dna[0] == 'A')
            currNum[0]++;
        else if (dna[0] == 'C')
            currNum[1]++;
        else if (dna[0] == 'T')
            currNum[2]++;
        else
            currNum[3]++;
        while(i < n) {
            while (!(currNum[0] >= needed[0] && currNum[1] >= needed[1] && currNum[2] >= needed[2] &&
                    currNum[3] >= needed[3]) && j<n) {
                j++;
                if (j==n) {
                    break;
                }
                if (dna[j] == 'A')
                    currNum[0]++;
                else if (dna[j] == 'C')
                    currNum[1]++;
                else if (dna[j] == 'T')
                    currNum[2]++;
                else
                    currNum[3]++;
            }
            if (j==n) {
                break;
            }
            minCount = Math.min(minCount, j-i+1);
            while((currNum[0] >= needed[0] && currNum[1] >= needed[1] && currNum[2] >= needed[2] &&
                    currNum[3] >= needed[3]) && i<n) {
                minCount = Math.min(minCount, j-i+1);
                if (dna[i] == 'A')
                    currNum[0]--;
                else if (dna[i] == 'C')
                    currNum[1]--;
                else if (dna[i] == 'T')
                    currNum[2]--;
                else
                    currNum[3]--;
                i++;
            }
            if(i==n)
                break;
        }
        System.out.print(minCount == Integer.MAX_VALUE ? -1 : minCount);
    }
}
