public class No409 {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int ret = 0;
        for (int num : freq) {
            ret += num / 2 * 2;
            if (num % 2 == 1 && ret % 2 == 0) {
                ret++;
            }
        }
        return ret;
    }
}
