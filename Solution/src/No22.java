import java.util.ArrayList;
import java.util.List;

public class No22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, n, new StringBuilder());
        return res;
    }

    private void backtrack(int left, int right, StringBuilder curr) {
        if (left > right) {
            return;
        } else if (left < 0 || right < 0) {
            return;
        } else if (left == 0 && right == 0) {
            res.add(curr.toString());
            return;
        }

        curr.append("(");
        backtrack(left-1, right, curr);
        curr.deleteCharAt(curr.length()-1);

        curr.append(")");
        backtrack(left, right-1, curr);
        curr.deleteCharAt(curr.length()-1);
    }
}
