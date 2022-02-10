package dp.re;

import java.util.Arrays;

public class L213_打家劫舍II {
    public int rob(int[] nums){
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, len -1)),
                myRob(Arrays.copyOfRange(nums, 1, len)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0,tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(cur, num + pre);
            pre = tmp;
        }
        return cur;
    }
}
