public class No75 {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < freq[0]) {
                nums[i] = 0;
            } else if (i < freq[0] + freq[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
