package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> xstack;
    Deque<Integer> minStack;

    public MinStack() {
        xstack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xstack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        xstack.pop();
        minStack.pop();
    }

    public int top() {
       return xstack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
