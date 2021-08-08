public class No59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curNum = 1;
        int curDirection = 0;
        int row = 0, col = 0;
        while (curNum <= n * n) {
            matrix[row][col] = curNum++;
            int nextRow = row + direction[curDirection][0];
            int nextCol = col + direction[curDirection][1];
            if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == n || matrix[nextRow][nextCol] != 0) {
                curDirection = (curDirection + 1) % 4;
            }
            row = row + direction[curDirection][0];
            col = col + direction[curDirection][1];
        }
        return matrix;
    }

    public int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int curNum = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = curNum;
                curNum++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = curNum;
                curNum++;
            }
            if (left < right) {
                for (int col = right - 1; col >= left; col--) {
                    matrix[bottom][col] = curNum;
                    curNum++;
                }
                for (int row = bottom - 1; row > top; row--) {
                    matrix[row][left] = curNum;
                    curNum++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
