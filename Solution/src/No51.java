import java.util.LinkedList;
import java.util.List;

public class No51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        LinkedList<String> board = fillBoard(n);
        backtrack(0, board);
        return res;
    }

    private LinkedList<String> fillBoard(int n) {
        LinkedList<String> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        return board;
    }

    private void backtrack(int rowNum, LinkedList<String> board) {
        if (rowNum == board.size()) {
            res.add(new LinkedList<>(board));
            return;
        }

        String row = board.get(rowNum);

        for (int col = 0; col < board.size(); col++) {
            if (!isValid(board, rowNum, col)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(row);
            sb.replace(col, col+1, "Q");
            board.set(rowNum, sb.toString());

            backtrack(rowNum+1, board);

            board.set(rowNum, row);
        }
    }

    private boolean isValid(LinkedList<String> board, int rowNum, int colNum) {
        for (String s : board) {
            if (s.charAt(colNum) == 'Q') {
                return false;
            }
        }

        for (int i = rowNum-1, j = colNum+1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = rowNum-1, j = colNum-1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
