import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        List[] dp = new List[nums.length];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            List<Integer> maxSubset = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && maxSubset.size() < dp[j].size()) {
                    maxSubset = dp[j];
                }
            }
            dp[i] = new ArrayList<>(maxSubset);
            dp[i].add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (List list : dp) {
            if (res.size() < list.size()) {
                res = list;
            }
        }
        return res;
    }
}
