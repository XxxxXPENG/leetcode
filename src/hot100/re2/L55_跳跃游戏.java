package hot100.re2;

public class L55_跳跃游戏 {

    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] nums){
        int len = nums.length, max = nums[0];
        for (int i = 1; i < len; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
