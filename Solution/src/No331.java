import java.util.Deque;
import java.util.LinkedList;
public class No331 {
    /* Using Deque t = O(N), s = O(N) */
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        while (i < n) {
            if (!stack.isEmpty()) {
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    int top = stack.pop();
                    top -= 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    i++;
                } else {
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    int top = stack.pop();
                    top -= 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    stack.push(2);
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /* Using integer simulate Deque t = O(N), s = O(1) */
    public boolean isValidSerialization1(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots != 0) {
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    slots --;
                    i++;
                } else {
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    slots ++;
                }
            } else {
                return false;
            }
        }
        return slots == 0;
    }
}
