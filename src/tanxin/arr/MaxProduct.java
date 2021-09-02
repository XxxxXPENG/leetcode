package tanxin.arr;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num * max, num);
            min = Math.min(num * min, num);
            res = Math.max(res, max);
        }
        return res;
    }


    public int maxProduct2(int[] nums) {
        int res = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果为负数或0，则先记录之前的数
            if (nums[i] <= 0) {
                res = Math.max(res, temp);
            }
            temp *= nums[i];
        }
        return Math.max(res, temp);
    }
}
