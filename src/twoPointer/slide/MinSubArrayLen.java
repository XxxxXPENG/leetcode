package twoPointer.slide;

public class MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end];
            if (sum >= s) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
