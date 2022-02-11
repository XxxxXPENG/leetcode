package dp.re;

public class L45_跳跃游戏II {
    public static void main(String[] args) {
        L45_跳跃游戏II a = new L45_跳跃游戏II();
        System.out.println(a.jump(new int[]{2,3,1,1,4}));
    }


    public int jump(int[] nums) {
        int res = 0, end = 0,max=0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == end) {
                end = max;
                res++;
            }
        }
        return res;
    }
}
