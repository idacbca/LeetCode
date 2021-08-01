public class No73 {
    /* Space O(m + n) */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowFlag[i] || colFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /* Space o(1) */
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowFlag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
