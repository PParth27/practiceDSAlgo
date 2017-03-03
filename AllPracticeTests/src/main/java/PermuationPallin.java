/**
 * Created by pparth on 4/23/16.
 */
public class PermuationPallin {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String test = "abcdegh";
        PermuationPallin permuationPallin = new PermuationPallin();
        permuationPallin.printPermu("", test);
    }

    /**
     *
     * @param left
     * @param right
     */
    public void printPermu(String left, String right) {
        if (right.length() == 1) {
            System.out.println(left + right);
        } else {
            char[] rightChar = right.toCharArray();
            char temp;
            for (int i = 0; i < rightChar.length; i++) {
                temp = rightChar[i];
                rightChar[i] = rightChar[0];
                rightChar[0] = temp;
                String newStr = new String(rightChar);
                printPermu(left + newStr.substring(0, 1), newStr.substring(1, rightChar
                        .length));
            }
        }

    }
}
