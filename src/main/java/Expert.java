import org.apache.commons.lang3.time.StopWatch;

/**
 * Created by pparth on 4/29/16.
 */
public class Expert {

    public static boolean checker(int i, int j, int val, int rows, int cols, int[] state) {
        if (i<1 || i>rows || j<1 || j>cols) {
            return false;
        }
        return (state[((i-1) * cols) + (j-1)] == val);
    }
    public static void printFinal(int[] input1, int[] input2) {
        int rows = input1[0];
        int cols = input1[1];
        int s1 = input1[2];
        int s2 = input1[3];
        int b1 = input1[4];
        int b2 = input1[5];
        int numIter = input1[6];
        int[] state2 = new int[input2.length];
        int nei,i,j;
        for(int k = 0; k<numIter ; k++) {
            for (int curr = 0; curr < input2.length; curr++) {
                i = curr / cols + 1;
                j = curr % cols + 1;
                nei = 0;
                    if (checker(i-1, j, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i-1, j-1, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i-1, j+1, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i, j-1, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i, j+1, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i+1, j, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i+1, j-1, 1, rows, cols, input2)) {
                        nei++;
                    } if (checker(i+1, j+1, 1, rows, cols, input2)) {
                        nei++;
                    }
                    if (input2[curr] == 1) {
                        if (nei < s1 || nei > s2) {
                            state2[curr] = 0;
                        } else {
                            state2[curr] = 1;
                        }
                    }
                    if (input2[curr] == 0) {
                        if (nei < b1 || nei > b2) {
                            state2[curr] = 0;
                        } else {
                            state2[curr] = 1;
                        }
                    }

            }
            input2 = state2.clone();
        }
        for (int pp = 0; pp < input2.length; pp++) {
            System.out.print(input2[pp] + " ");
        }
    }
    public static void main(String[] args) {
        int[] val = {3,4,2,3,3,3,4};
        int[] state = {0,1,0,0,0,1,1,0,1,0,1,0};
        //int[] state = {0,0,0,0,0,0,0,0,0,0,0,0};
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        printFinal(val, state);
        stopwatch.stop();
        System.out.print("\n" + stopwatch.getNanoTime());
    }
}
