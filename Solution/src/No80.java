public class No80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 2;
        for (int j = 2; j < nums.length; j ++) {
            if (nums[i - 2] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
