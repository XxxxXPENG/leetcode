package dp.re;

public class L55_跳跃游戏 {
    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < i) {
                return false;
            }
            end = Math.max(end, nums[i] + i);
        }
        return true;
    }
}
