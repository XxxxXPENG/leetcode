package dp;

/**
 * 数组的最后一个元素和第一个元素相邻
 */
public class L213_打家劫舍II {
    public int rob(int[] nums) {
        int len = nums.length;
        int res1 = robRes(nums, 1, len);
        int res2 = robRes(nums, 0, len - 1);
        return Math.max(res1, res2);
    }

    public int robRes(int[] nums, int start, int end) {
        int pre = 0, cur = 0,tmp;
        for (int i = start; i < end; i++) {
            tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }

}
