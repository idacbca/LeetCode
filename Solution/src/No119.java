import java.util.LinkedList;
import java.util.List;

public class No119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new LinkedList<>();
        curRow.add(1);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> nextRow = new LinkedList<>();
            nextRow.add(1);
            for (int j = 0; j < curRow.size() - 1; j++) {
                int num = curRow.get(j) + curRow.get(j+1);
                nextRow.add(num);
            }
            nextRow.add(1);
            curRow = nextRow;
        }
        return curRow;
    }
}
