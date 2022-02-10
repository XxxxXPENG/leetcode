package dp.re;

public class L198_打家劫舍 {
    public int rob(int[] nums) {
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(cur, pre + num);
            pre = temp;
        }
        return cur;
    }
}
