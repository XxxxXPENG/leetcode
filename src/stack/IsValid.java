package stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {
    public static void main(String[] args) {
//        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("]"));
    }


    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
