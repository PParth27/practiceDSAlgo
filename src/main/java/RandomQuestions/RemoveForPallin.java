package RandomQuestions;

import java.util.Scanner;

/**
 * Created by pparth on 9/5/16.
 */
public class RemoveForPallin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();

        for(int k = 0;k<t;k++) {
            String word = in.next();
            boolean found = false;
            char[] wordArr = word.toCharArray();
            for(int i=0, j=word.length()-1;i<word.length();i++,j--) {
                if(wordArr[i] != wordArr[j]) {
                    found = true;
                    int ll = 1;
                    int kk = 0;
                    while(true) {
                        if(wordArr[i+ll] == wordArr[j - kk] && wordArr[j-ll] == wordArr[i + kk]) {
                            ll++;
                            kk++;
                        }else if(wordArr[i+ll] == wordArr[j - kk]) {
                            System.out.println(i);
                            break;
                        } else if(wordArr[j-ll] == wordArr[i + kk]){
                            System.out.println(j);
                            break;
                        } else {
                            System.out.println(-1);
                            break;
                        }
                    }
                    break;
                }
            }
            if(!found)
                System.out.println(-1);
        }
    }
}
