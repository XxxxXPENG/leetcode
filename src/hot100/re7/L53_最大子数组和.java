package hot100.re7;

public class L53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
