package dp;

public class L918_环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0,maxSum = nums[0],curMax = 0, minSum = nums[0],curMin = 0;
        for (int num : nums) {
            curMax = Math.max(num + curMax, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(num + curMin, num);
            minSum = Math.min(minSum, curMin);
            total+=num;
        }
        return maxSum > 0 ? Math.max(total - minSum, maxSum) : maxSum;
    }
}
