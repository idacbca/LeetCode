public class No240 {
    /* Binary search */
    public boolean searchMatrix(int[][] matrix, int target) {
        int iterateCount = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < iterateCount; i++) {
            if (search(matrix, i, target, true) || search(matrix, i, target, false)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[][] matrix, int start, int target, boolean vertical) {
        if (matrix[start][start] > target) {
            return false;
        }
        if (vertical) {
            int lo = start, hi = matrix.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[mid][start] == target) {
                    return true;
                } else if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                }
            }
        } else {
            int lo = start, hi = matrix[0].length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (matrix[start][mid] == target) {
                    return true;
                } else if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    /* Method 2 */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            }
        }
        return false;
    }
}
