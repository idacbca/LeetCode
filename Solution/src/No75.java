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

    /* Using one pointer */
    public void sortColors1(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[ptr];
                nums[ptr++] = 0;
                nums[i] = temp;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[ptr];
                nums[ptr++] = 1;
                nums[i] = temp;
            }
        }
    }

    /* Using two pointers */
    public void sortColors2(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = 0;
                nums[i] = temp;
                if (p0 < p1) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            }
        }
    }
}
