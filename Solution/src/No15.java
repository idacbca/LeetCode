import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            List<List<Integer>> temp = twoSum(nums, i + 1, 0 - nums[i]);
            for (List<Integer> twoNum : temp) {
                twoNum.add(nums[i]);
                res.add(twoNum);
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i ++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int l = start, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r --;
            } else if (sum < target) {
                l ++;
            } else {
                List<Integer> temp = new LinkedList<>();
                int numl = nums[l], numr = nums[r];
                temp.add(numl);
                temp.add(numr);
                res.add(temp);
                while (l < r && nums[l] == numl) {
                    l ++;
                }
                while (l < r && nums[r] == numr) {
                    r --;
                }
            }
        }
        return res;
    }
}
