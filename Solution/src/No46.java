import java.util.LinkedList;
import java.util.List;

public class No46 {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
