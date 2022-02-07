package dp;

public class L45_跳跃游戏II {

    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            //尽可能远
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //所有能跳的步数都穷举后，更新右边界
            if (i == end) {
                end = maxPosition;
                res++;
            }
        }
        return res;
    }
}
