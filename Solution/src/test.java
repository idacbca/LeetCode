import org.junit.Assert;
import org.junit.Test;

public class test {
    @Test
    public void test1() {
        int[] A = {3, 6, 5, 1, 8};
        int sum = maxSum(A);
        Assert.assertEquals(18, sum);
    }

    private int maxSum(int[] A) {
        int[] state = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i : A) {
            if (i % 3 == 0) {
                state[0] += i;
                state[1] += i;
                state[2] += i;
            } else if (i % 3 == 1) {
                int a = Math.max(state[0], state[2] + i);
                int b = Math.max(state[1], state[0] + i);
                int c = Math.max(state[2], state[1] + i);
                state = new int[]{a, b, c};
            } else if (i % 3 == 2) {
                int a = Math.max(state[0], state[1] + i);
                int b = Math.max(state[1], state[2] + i);
                int c = Math.max(state[2], state[0] + i);
                state = new int[]{a, b, c};
            }
        }
        return state[0];
    }
}
