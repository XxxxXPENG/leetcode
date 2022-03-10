package hot100;

import java.util.Stack;

public class L20_有效的括号 {

    public static void main(String[] args) {
        L20_有效的括号 a = new L20_有效的括号();
        System.out.println(a.isValid("}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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
