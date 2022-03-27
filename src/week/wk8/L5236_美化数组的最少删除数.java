package week.wk8;

import java.util.Deque;
import java.util.LinkedList;

public class L5236_美化数组的最少删除数 {
    public int minDeletion(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(nums[0]);
        //美丽数组要求 1）长度为偶数  2）下标为偶数时，后一位数和当前数不重复
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
        //操作次数 = 数组长度 - 美丽数组的长度
        //最后栈为奇数则删掉栈顶元素，次数+1
        if (deque.size() % 2 != 0) {
            return len - deque.size() + 1;
        }
        return len - deque.size();
    }


    public static void main(String[] args) {
        L5236_美化数组的最少删除数 a = new L5236_美化数组的最少删除数();
        System.out.println(a.minDeletion(new int[]{1,1,2,2,3,3}));
    }
}
