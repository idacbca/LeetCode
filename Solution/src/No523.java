import java.util.HashMap;
import java.util.Map;

public class No523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        Map<Integer, Integer> remainderTable = new HashMap<>();
        remainderTable.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (remainderTable.containsKey(remainder)) {
                int prevIndex = remainderTable.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                remainderTable.put(remainder, i);
            }
        }
        return false;
    }
}
