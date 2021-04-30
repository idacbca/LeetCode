import java.util.HashMap;
import java.util.Map;

public class No137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> appearTimes = new HashMap<>();

        for (int num : nums) {
            appearTimes.put(num, appearTimes.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : appearTimes.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }
}
