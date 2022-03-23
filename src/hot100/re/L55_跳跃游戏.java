package hot100.re;

public class L55_跳跃游戏 {
    //
    public static void main(String[] args) {
        L55_跳跃游戏 a = new L55_跳跃游戏();
        System.out.println(a.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int max = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if(max >= i){
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
