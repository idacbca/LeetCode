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
}
