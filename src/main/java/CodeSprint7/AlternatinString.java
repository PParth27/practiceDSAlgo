package CodeSprint7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by pparth on 9/24/16.
 */
public class AlternatinString {

    static int ans = 0;
    static String input;

    static boolean isValidString(char[] val) {
        if(val.length < 2)
            return false;
        char a = val[0];
        char b = val[1];
        if(a == b)
            return false;
        for(int i=2;i < val.length;i++) {
            if(i%2==0) {
                if(val[i] != a)
                    return false;
            } else {
                if(val[i] != b)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] wed) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        input = in.next();
        String in2;
        Set<Character> cc = new HashSet<>();
        for(char curr : input.toCharArray())
            cc.add(curr);
        List<Character> chars = new ArrayList<>(cc);
        char a,b;
        for(int i=0;i<chars.size()-1;i++) {
            for(int j=1;j<chars.size();j++) {
                in2=input;
                a = chars.get(i);
                b = chars.get(j);
                for(Character c : chars) {
                    if(c != a && c != b) {
                        in2 = in2.replace(String.valueOf(c), "");
                    }
                }
                if(isValidString(in2.toCharArray())) {
                    ans = Math.max(in2.length(), ans);
                    System.out.println(in2);
                }
            }
        }
        System.out.print(ans);
    }

}
