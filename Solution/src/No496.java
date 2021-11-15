import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> numIndex = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            numIndex.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            if (numIndex.containsKey(num)) {
                res[numIndex.get(num)] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(num);
        }
        return res;
    }
}
