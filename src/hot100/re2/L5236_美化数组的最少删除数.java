package hot100.re2;

import java.util.Deque;
import java.util.LinkedList;

public class L5236_美化数组的最少删除数 {

    public static void main(String[] args) {
        L5236_美化数组的最少删除数 a = new L5236_美化数组的最少删除数();
        System.out.println(a.minDeletion(new int[]{1,1,2,2,3,3}));
    }

    public int minDeletion(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[0]);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (deque.size() % 2 == 0) {
                deque.push(nums[i]);
            } else {
                if (deque.peek() == nums[i]) {
                    continue;
                }
                deque.push(nums[i]);
            }
        }
        if (deque.size() % 2 == 0) {
            return len - deque.size();
        }
        return len - deque.size()+1;
    }
}
