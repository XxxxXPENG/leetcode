package dp;

public class L376_摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1, pre = 0, cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i - 1];
            if ((cur < 0 && pre >= 0) || (cur > 0 && pre <= 0)) {
                res++;
                pre = cur;
            }
        }
        return res;
    }
}
