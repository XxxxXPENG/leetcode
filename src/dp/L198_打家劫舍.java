package dp;

public class L198_打家劫舍 {
    /**
     * 转态转移方程： dp[n+1] = Math.max(dp[n],dp[n-1]+num)
     * 解释： n+1个房的最大金额有两种可能
     *  1） 不抢n+1房，则金额为前面dp[n]
     *  2） 抢n+1房，则金额为dp[n-1] + num
     *
     *  优化：发现最后结果只与前面倒数1 2个有关，类似兔子问题
     *  可将空间优化为O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int pre = 0,cur = 0,temp ;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }
}
