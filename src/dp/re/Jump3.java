package dp.re;

public class Jump3 {
    public static void main(String[] args) {
        Jump3 a = new Jump3();
        System.out.println(a.jump(new int[]{1,0,3,1,4}));
    }

    public boolean jump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果能走的最大边界小于了i，说明卡主了
            if (i > end) {
                return false;
            }
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }
}
