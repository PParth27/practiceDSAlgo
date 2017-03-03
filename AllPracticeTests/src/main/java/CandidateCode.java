import java.io.*;

public class CandidateCode
{

    public static String minimumCost(String[] input1,int input2)
    {
        if(input2 <= 1) {
            return "NA";
        }
        if(input1.length != input2) {
            return "NA";
        }

        int numCol = input1[0].split("#").length;
        int[][] dis = new int[input2][numCol];
        int[][] calculated = new int[input2][numCol];
        String[][] path = new String[input2][numCol];
        path[0][0] = "";
        int counter = 0;
        try {
            for (int i = 0; i < input2; i++) {
                counter = 0;
                for (String str : input1[i].split("#")) {
                    dis[i][counter++] = Integer.parseInt(str);
                }
            }
            for (int i = 0; i < input2; i++) {
                for (int j = 0; j < numCol; j++) {
                    if (i == 0 && j == 0) {
                        calculated[i][j] = dis[i][j];
                    } else {
                        int top = (i - 1 >= 0) ? calculated[i - 1][j] : Integer.MAX_VALUE;
                        int left = (j - 1 >= 0) ? calculated[i][j - 1] : Integer.MAX_VALUE;
                        int diagonal = (i - 1 >= 0 && j - 1 >= 0) ? calculated[i - 1][j - 1] : Integer.MAX_VALUE;
                        calculated[i][j] = Math.min(top, Math.min(left, diagonal)) + dis[i][j];
                        if (calculated[i][j] - dis[i][j] == top) {
                            path[i][j] = path[i - 1][j] + "B";
                        }
                        if (calculated[i][j] - dis[i][j] == left) {
                            path[i][j] = path[i][j - 1] + "R";
                        }
                        if (calculated[i][j] - dis[i][j] == diagonal) {
                            path[i][j] = path[i - 1][j - 1] + "D";
                        }
                    }
                }
            }
            return String.valueOf(calculated[input2 - 1][numCol - 1]) + "," + path[input2 - 1][numCol - 1];
        } catch (Exception e) {
            return "NA";
        }
    }

    public static void main(String[] args) {

        int len = 3;
        String[] value = {"5#7#2#4#6", "1#8#1#3#7", "6#2#9#5#87"};
        System.out.print(minimumCost(value, len));
    }
}