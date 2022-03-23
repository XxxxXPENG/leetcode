package hot100.re;

public class L53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for (int num : nums) {
            if (sum  > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
