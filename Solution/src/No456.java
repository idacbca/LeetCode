import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class No456 {
    /* Enumerate 3 */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        for (int i = 2; i < nums.length; i ++) {
            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
        }

        int left = nums[0];
        for (int i = 1; i < nums.length - 1; i ++) {
            int cur = nums[i];
            if (left < cur) {
                Integer right = rightAll.ceilingKey(left + 1);
                if (right != null && right < cur) {
                    return true;
                }
            }
            left = Math.min(left, nums[i]);
            rightAll.put(nums[i + 1], rightAll.get(nums[i + 1]) - 1);
            if (rightAll.get(nums[i + 1]) == 0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }

    /* Enumerate 1 */
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        Deque<Integer> candidate = new LinkedList<>();
        candidate.push(nums[n - 1]);
        int twoMax = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; i --) {
            if (nums[i] < twoMax) {
                return true;
            }
            while (!candidate.isEmpty() && nums[i] > candidate.peek()) {
                twoMax = Math.max(twoMax, candidate.pop());
            }
            if (nums[i] > twoMax) {
                candidate.push(nums[i]);
            }
        }
        return false;
    }
}
