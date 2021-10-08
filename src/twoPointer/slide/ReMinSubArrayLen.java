package twoPointer.slide;

public class ReMinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
