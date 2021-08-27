package tanxin;

public class FindMinMoves {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) {
            return -1;
        }
        int len = machines.length;
        int sum = 0;
        for (int num : machines) {
            sum += num;
        }
        //如果不为洗衣机整数倍返回-1
        if (sum % len != 0) {
            return -1;
        }

        //减去平均值
        int dressPerMachines = sum / len;
        for (int i = 0; i < len; i++) {
            machines[i] -= dressPerMachines;
        }

        int curSum = 0, maxSum = 0, tempRes = 0, res = 0;
        for (int num : machines) {
            curSum += num;
            maxSum = Math.max(maxSum, Math.abs(curSum));
            tempRes = Math.max(maxSum, num);
            res = Math.max(tempRes, res);
        }
        return res;
    }
}
