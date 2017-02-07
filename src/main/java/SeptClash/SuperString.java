package SeptClash;

import java.util.Scanner;

/**
 * Created by pparth on 9/10/16.
 */
public class SuperString {

    private static String ans;

    private static void populateMin(int i, int j, String word, int k) {
        if(k==0)
            return;
        String word2;
        while (i < word.length()) {
            j=i;
            while (j < word.length()) {
                if(!(i==0 && j==word.length()-1)) {
                    word2 = word.substring(0, i) + word.substring(j + 1, word.length());
                    System.out.println(word2);
                    if(ans.length() > word2.length())
                        ans = word2;
                    else if(ans.length() == word2.length() && ans.compareTo(word2) > 0)
                        ans=word2;
                    populateMin(0,0, word2, k-1);
                }
                j++;
            }
            i++;
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t>0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String word = in.next();
            ans = word;
            populateMin(0,0, word, k);
            System.out.println(ans);
            t--;
        }
    }
}
