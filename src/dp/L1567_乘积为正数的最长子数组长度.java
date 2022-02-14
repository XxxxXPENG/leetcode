package dp;

public class L1567_乘积为正数的最长子数组长度 {
    public static void main(String[] args) {
        L1567_乘积为正数的最长子数组长度 a = new L1567_乘积为正数的最长子数组长度();
        System.out.println(a.getMaxLen(new int[]{0,1,-2,-3,-4}));
    }

    public int getMaxLen(int[] nums) {
        int len = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int res = positive;
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                negative = ++positive;
                positive = newPositive;
            } else {
                positive = 0;
                negative = 0;
            }
            res = Math.max(positive, res);
        }
        return res;
    }
}
