package hot100.re4;

public class L55_跳跃游戏 {
    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums) {
        int maxStep = nums[0], len = nums.length;
        for (int i = 1; i < len; i++) {
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
