public class No334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int max : nums) {
            if (max < min) {
                min = max;
            } else if (max > min && max < mid) {
                mid = max;
            } else if (mid < max){
                return true;
            }
        }
        return false;
    }
}
