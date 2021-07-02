import java.util.*;

public class No217 {
    /* First attempt */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashTable.containsKey(num)) {
                return true;
            } else {
                hashTable.put(num, 1);
            }
        }
        return false;
    }

    /* Using HashSet */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    /* Sort */
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
