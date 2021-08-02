import java.util.Queue;
import java.util.LinkedList;

public class No225 {
    Queue<Integer> queue;
    int topElement;

    /** Initialize your data structure here. */
    public No225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        topElement = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size -= 1;
        }
        topElement = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
