package hot100.re4;

import java.util.Deque;
import java.util.LinkedList;

public class L5236_美化数组的最少删除数 {
    public static void main(String[] args) {
        L5236_美化数组的最少删除数 a = new L5236_美化数组的最少删除数();
        System.out.println(a.minDeletion(new int[]{1,1,2,2,3,3}));
    }
    public int minDeletion(int[] nums) {
        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (deque.size() % 2 == 0) {
                deque.push(nums[i]);
            } else {
                if ( deque.peek() == nums[i]) {
                   continue;
                }
                deque.push(nums[i]);
            }
        }
        if (deque.size() % 2 == 0) {
            return len - deque.size();
        }
        return len - deque.size() + 1;
    }
}
