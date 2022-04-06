package hot100.re7;

public class L55_跳跃游戏 {
    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{3}));
    }

    public boolean canJump(int[] nums) {
        int maxStep = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (maxStep >= i) {
                maxStep = Math.max(i + nums[i],maxStep);
                if (maxStep >= len - 1) {
                    return true;
                }
            }
        }
        return false;

    }
}
