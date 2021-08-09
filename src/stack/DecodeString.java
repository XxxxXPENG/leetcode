package stack;


import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String str = "3[a2[c]]";
    }
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numStack.push(Integer.parseInt(c + ""));
            } else if (c == '[') {
                StringBuilder sb = new StringBuilder();
                int index = i;
                while (index < s.length()) {

                }
            }
        }
        return "";
    }

}
