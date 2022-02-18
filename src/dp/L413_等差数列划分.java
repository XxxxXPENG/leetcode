package dp;

public class L413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int res = 0, count = 0, d = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == d) {
                count++;
            } else {
                d = nums[i] - nums[i - 1];
                count = 0;
            }
            res+=count;
        }
        return res;
    }
}
