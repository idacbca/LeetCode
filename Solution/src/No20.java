import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

public class No20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
