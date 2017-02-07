import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pparth on 4/29/16.
 */
public class ExpertNew {

    public static int checker(int i, int j, int rows, int cols, int[] state) {
        if (i < 1 || i > rows || j < 1 || j > cols) {
            return -1;
        }
        return state[((i-1) * cols) + (j-1)];
    }
    public static void printFinal(int[] data, int[] state) {
        int rows = data[0];
        int cols = data[1];
        int s1 = data[2];
        int s2 = data[3];
        int b1 = data[4];
        int b2 = data[5];
        int numIter = data[6];
        int sInx = 0;
        //int[][] matrix = new int[rows + 1][cols + 1];
        //int[][] matrix1 = new int[rows + 1][cols + 1];
        int[] state1;
        Map<Integer, Integer> zerosAround;
        List<Integer> planted = new ArrayList<>();
        List<Integer> planted1;
        for (int i = 0; i < state.length; i++) {
            if(state[i] == 1) {
                planted.add(i);
            }
        }
        int neiNum;
        int neiVal;
        int value;
        int pos;
        for(int k =0 ;k < numIter ; k++) {
            planted1 = new ArrayList<>();
            state1 = new int[state.length];
            zerosAround = new HashMap<>();
            for (Integer curr : planted) {
                int i = curr/cols +1;
                int j = curr%cols+1;
                neiNum = 0;

                neiVal = checker(i - 1, j, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i-1)-1) * cols) + (j-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i - 1, j - 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i-1)-1) * cols) + ((j-1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i - 1, j + 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i-1)-1) * cols) + ((j+1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i, j - 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i)-1) * cols) + ((j-1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i, j + 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i)-1) * cols) + ((j+1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i + 1, j, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i+1)-1) * cols) + ((j)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i + 1, j - 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i+1)-1) * cols) + ((j-1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                neiVal = checker(i + 1, j + 1, rows, cols, state);
                if (neiVal == 1) {
                    neiNum++;
                } else if (neiVal == 0) {
                    pos = (((i+1)-1) * cols) + ((j+1)-1);
                    value = (zerosAround.get(pos) != null) ? zerosAround.get(pos) + 1 : 1;
                    zerosAround.put(pos, value);
                }

                if (neiNum < s1 || neiNum > s2) {
                    state1[curr] = 0;
                } else {
                    state1[curr] = 1;
                    planted1.add(curr);
                }
            }
            if (!(0 < b1 || 0 > b2)) {
                for(int pp = 0 ; pp<state.length ; pp++) {
                    if(state[pp] == 0 && (zerosAround.get(pp) == null)) {
                        state1[pp] = 1;
                        planted1.add(pp);
                    }
                }
            }
            for(Map.Entry<Integer, Integer> entry : zerosAround.entrySet()) {
                if(entry.getValue() < b1 || entry.getValue() > b2) {
                    state1[entry.getKey()] = 0;
                } else {
                    state1[entry.getKey()] = 1;
                    planted1.add(entry.getKey());
                }
            }
            //zerosAround.forEach((key, val) -> state1[key] = (val < b1 || val > b2) ? 0 : 1);
            state = state1.clone();
            planted = new ArrayList<>(planted1);
        }
        for(int i=0;i<state.length;i++) {
            System.out.print(state[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] val = {3,4,2,3,0,0,3};
        //int[] state = {0,1,0,0,0,1,1,0,1,0,1,0};
        int[] state = {0,0,0,0,0,0,0,0,0,0,0,0};
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        printFinal(val, state);
        stopwatch.stop();
        System.out.print("\n" + stopwatch.getNanoTime());
    }
}
