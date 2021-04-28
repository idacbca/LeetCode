public class No633 {
    /* Using Math.sqrt() */
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a ++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /* Using two pointers, though the complexity is the same in the worst case */
    public boolean judgeSquareSum2(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left < right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return (left * left + right * right) == c;
    }
}
