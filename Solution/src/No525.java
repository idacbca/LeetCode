import java.util.HashMap;
import java.util.Map;

public class No525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int counter = 0, maxLength = 0;
        Map<Integer, Integer> gapTable = new HashMap<>();
        gapTable.put(0, -1);
        for (int i = 0; i < n; i++) {
            counter += nums[i] == 0 ? -1 : 1;
            if (gapTable.containsKey(counter)) {
                int prevIndex = gapTable.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                gapTable.put(counter, i);
            }
        }
        return maxLength;
    }
}
