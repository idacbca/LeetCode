import java.util.LinkedList;
import java.util.List;

public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new LinkedList<>();
            row.add(1);
            for (int j = 0; j < i; j++) {
                if (j == i - 1) {
                    row.add(1);
                } else {
                    row.add(res.get(i-1).get(j) + res.get(i-1).get(j+1));
                }
            }
            res.add(row);
        }
        return res;
    }
}
