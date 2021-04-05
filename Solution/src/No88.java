public class No88 {
    /* O(m + n) & O(m + n) */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m || j < n) {
            if (i == m) {
                merged[index++] = nums2[j++];
            } else if (j == n) {
                merged[index++] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                merged[index++] = nums1[i++];
            } else {
                merged[index++] = nums2[j++];
            }
        }
        for(i = 0; i < m + n; i ++) {
            nums1[i] = merged[i];
        }
    }
    /* O(m + n) & O(1) */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (index >= 0) {
            if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }
}
