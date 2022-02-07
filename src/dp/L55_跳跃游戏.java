package dp;

public class L55_跳跃游戏 {

    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{}));
    }

    public boolean canJump(int[] nums) {
        int end = 0, maxPosition = 0;
        int len = nums.length;
        if(len == 1) return true;
        for (int i = 0; i < len - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
            }
            if (end >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
