package tanxin.stack;

import java.util.*;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters2("cbacdcbc"));
    }

    public static String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            count[c]--;
            //重复元素跳过
            if(inStack[c]){
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


}
