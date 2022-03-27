package hot100;

public class L70_爬楼梯 {

    public int climbStairs(int n) {
        int pre = 0,cur = 0, sum = 1;
        for (int i = 1; i <= n; i++) {
            pre = cur;
            cur = sum;
            sum = pre + cur;
        }
        return sum;
    }
}
