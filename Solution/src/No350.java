import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect (nums2, nums1);
        }
        int[] res = new int[nums1.length];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums1) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for (int num : nums2) {
            int count = counter.getOrDefault(num, 0);
            if (count > 0) {
                res[i++] = num;
                counter.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, i);
    }
}
