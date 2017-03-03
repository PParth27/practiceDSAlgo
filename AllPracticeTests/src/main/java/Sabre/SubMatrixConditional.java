import java.util.Scanner;
public class SubMatrixConditional {
    public static void main(String[] ashv) {
        Scanner in = new Scanner(System.in);
        int[][] matrix;
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long totalCount = 0;
        matrix = new int[n+1][m+1];
        for(int i =0;i<n;i++) {
            for(int j=0;j<m;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int mX = 2;
        while(mX<=n) {
            int mY = 2;
            while (mY<=m) {
                int iStart = 0;
                while(iStart<n) {
                    if(iStart+mX > n)
                        break;
                    int jStart = 0;
                    while(jStart<m) {
                        if(jStart+mY > m)
                            break;
                        int count = 0;
                        boolean isCornorOk = false;
                        int tl, tr, bl,br;
                        tl = matrix[iStart][jStart];
                        tr = matrix[iStart][jStart+mY-1];
                        bl = matrix[iStart+mX-1][jStart];
                        br = matrix[iStart+mX-1][jStart+mY-1];
                        if(tl == tr || tl == bl || tl == br || tr == bl || tr == br || bl == br) {
                            isCornorOk = true;
                        }
                        if(isCornorOk) {
                            for (int i = iStart; i < iStart + mX; i++) {
                                for (int j = jStart; j < jStart + mY; j++) {
                                    if (matrix[i][j] == x) {
                                        count++;
                                    }
                                }
                            }
                        }
                        if(isCornorOk && count >= k)
                            totalCount++;
                        jStart++;
                    }
                    iStart++;
                }
                mY++;
            }
            mX++;
        }
        System.out.println(totalCount);
    }
}