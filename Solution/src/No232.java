import java.util.Stack;

public class No232 {
    private Stack<Integer> front, back;

    /** Initialize your data structure here. */
    public No232() {
        front = new Stack<>();
        back = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        back.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (front.isEmpty()) {
            while(!back.isEmpty()) {
                front.add(back.pop());
            }
        }
        return front.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (front.isEmpty()) {
            while(!back.isEmpty()) {
                front.add(back.pop());
            }
        }
        return front.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return front.isEmpty() && back.isEmpty();
    }
}
