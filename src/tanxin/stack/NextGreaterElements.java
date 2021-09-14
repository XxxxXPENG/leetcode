package tanxin.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,1})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % len]) {
                int index = stack.pollLast();
                if (res[index] == -1) {
                    res[index] = nums[i % len];
                }
            }
            stack.addLast(i % len);
        }
        return res;
    }
}
