import java.util.HashSet;
public class No36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            boxes[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) {
                        return false;
                    }
                    int num = j / 3 + (i / 3) * 3;
                    if (!boxes[num].add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!col.add(board[j][i])) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
