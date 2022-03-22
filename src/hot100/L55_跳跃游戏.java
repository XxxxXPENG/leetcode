package hot100;

public class L55_跳跃游戏 {
    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
    }

    /**
     * 遍历每个位置能走的最远距离
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int  max = 0,len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
