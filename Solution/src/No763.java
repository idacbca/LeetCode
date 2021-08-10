import java.util.LinkedList;
import java.util.List;

public class No763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new LinkedList<>();
        int last = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastPos[s.charAt(i) - 'a']);
            size++;
            if (i == last) {
                partition.add(size);
                size = 0;
            }
        }
        return partition;
    }
}
