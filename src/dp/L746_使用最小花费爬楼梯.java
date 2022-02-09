package dp;

public class L746_使用最小花费爬楼梯 {
    public static void main(String[] args) {
        L746_使用最小花费爬楼梯 a = new L746_使用最小花费爬楼梯();
        System.out.println(a.minCostClimbingStairs2(new int[]{1, 100}));
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int down = 0;
        int downdown = 0;
        for (int i = 2; i <= n; i++) {
            int cur = Math.min(cost[i - 1] + down, cost[i - 2] + downdown);   // 到当前楼层两种路径消耗的体力最小值
            downdown = down;       //及时更新便于下一层循环，楼下就变成了楼下的楼下
            down = cur;      //当前楼层就变成了楼下
        }
        return down;
    }


}
