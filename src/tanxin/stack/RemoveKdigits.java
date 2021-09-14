package tanxin.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKdigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("12345", 2));
    }

    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        //单调递增情况，删除末尾
        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }

        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()) {
            char c = stack.pollFirst();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
