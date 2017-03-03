/**
 * Created by pparth on 5/8/16.
 */
public class SFP2Brute {

    static int rows;
    static int cols;
    public static class Pair {
        int x;
        int y;
        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int getMaxLine(int xS, int yS, int[][] matrix) {
        int maxCount = -1;
        int currCount;
        int jumpI = 0;
        int jumpJ, ii, jj;
        while (xS + jumpI <= rows) {
            jumpJ = 0;
            while (yS+jumpJ <= cols) {
                currCount = 0;
                if (!(jumpI == 0 && jumpJ == 0)) {
                    for (ii = xS, jj = yS; (ii <= rows && jj <= cols); ii += jumpI, jj += jumpJ) {
                        if (matrix[ii][jj] == 1) {
                            currCount++;
                        } else {
                            break;
                        }
                    }
                    if (currCount >= 3 && currCount > maxCount) {
                        maxCount = currCount;
                    }
                    if (!(jumpI == 0 || jumpJ == 0)) {
                        currCount = 0;
                        for (ii = xS, jj = yS; (ii <= rows && jj >= 1); ii += jumpI, jj -= jumpJ) {
                            if (matrix[ii][jj] == 1) {
                                currCount++;
                            } else {
                                break;
                            }
                        }
                        if (currCount >= 3 && currCount > maxCount) {
                            maxCount = currCount;
                        }
                    }
                }
                jumpJ += 1;
            }
            jumpI += 1;
        }
        return  maxCount;
    }

    public static int maxTreeDestroyed(int input1, int input2, int input3, String input4) {
        if(input1 < 1 || input1 > 100 || input2 < 1 || input2 > 100 || input3 < 3 || input3 > input1 * input2)
            return -1;
        rows = input1;
        cols = input2;
        int[][] matrix = new int[input1+1][input2+1];
        int c = 0;
        Pair[] matters = new Pair[input3];
        try {
            String coor = input4.substring(2, input4.length() - 2);
            String[] indCoor = coor.split("\\),\\(");
            String[] values;
            int x,y;
            for (String curr : indCoor) {
                values = curr.split(",");
                x = Integer.parseInt(values[0]);
                y = Integer.parseInt(values[1]);
                matrix[x][y] = 1;
                matters[c++] = new Pair(x,y);
            }
        } catch (Exception e) {
            return -1;
        }
        int maxCount = 0;
        for (Pair curr : matters) {
            maxCount = Math.max(maxCount, getMaxLine(curr.x, curr.y, matrix));
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int rows = 6;
        int cols = 7;
        int num = 13;
        String coor = "((2,1),(4,2),(2,5),(2,6),(2,7),(6,1),(6,2),(2,3),(6,3),(5,2),(4,3),(1,6),(3,3))";
        //int num = 15;
        //String coor = "((2,1),(2,3),(2,5),(2,6),(2,7),(3,3),(4,2),(4,3),(1,),(5,7),(6,1),(6,2),(6,3),(6,7),(2,4))";
        System.out.print(maxTreeDestroyed(rows, cols, num, coor));
    }
}
