package sf.dp;

public class Massage {
    /**
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     * @param nums
     * @return
     */
    public int massage(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],dp[1]+nums[0]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + nums[i];
        }
        return dp[n-1];
    }
}
