package arr;

import java.util.Arrays;

public class MaximumProduct {
    /**
     * 三个数乘机最大  -> 2个数乘机最大  * 第三个大数   （×）
     * eg:  -3 -2 -1 5 10
     * @param nums
     * @return
     */

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}
