package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exclusiveTime2(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
    }

    public static int[] exclusiveTime2(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;

    }


}
