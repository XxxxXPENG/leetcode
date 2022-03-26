package hot100;

public class L70_爬楼梯 {

    public int climbStairs(int n) {
        int pre = 0,cur = 0, sum = 1;
        for (int i = 1; i <= n; i++) {
            cur = sum;
            pre = cur;
            sum = pre + cur;
        }
        return sum;
    }
}
