import java.util.Arrays;
import java.util.Comparator;

public class No179 {
    public String largestNumber(int[] nums) {
        Integer[] numsArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, new Comparator<>(){
            public int compare(Integer a, Integer b) {
                int x = 10, y = 10;
                while (x <= a) x *= 10;
                while (y <= b) y *= 10;
                return (int) (-y*a - b + x*b + a);
            }
        });
        if (numsArr[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (Integer num : numsArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
