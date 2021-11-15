import java.util.ArrayDeque;
import java.util.Deque;

public class No503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] cirNums = new int[nums.length*2];
        int[] res = new int[nums.length];
        for (int i = 0; i < cirNums.length; i++) {
            cirNums[i] = nums[i%nums.length];
        }
        for (int i = cirNums.length - 1; i >= nums.length; i--) {
            while (!stack.isEmpty() && stack.peek() <= cirNums[i]) {
                stack.pop();
            }
            stack.push(cirNums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= cirNums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(cirNums[i]);
        }
        return res;
    }
}
