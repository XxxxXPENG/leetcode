package dp;

public class L152_乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1,min = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(max, res);
        }
        return res;
    }



}
