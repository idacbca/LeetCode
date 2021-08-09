import java.util.HashMap;
import java.util.Map;

public class No560 {
    /* Prefix sum + Map */
    public int subarraySum(int[] nums, int k) {
        int ret = 0, sum = 0;
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        for (int num : nums) {
            sum += num;
            ret += sumFreq.getOrDefault(sum - k, 0);
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
