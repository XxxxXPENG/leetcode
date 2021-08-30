package tanxin.arr;

public class CanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 如果从i开始，能到达的最后一个站下标为j。
     * 那么i到j之前的所有下标最大距离就是j，且都不能绕站一周。
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % len];
                j = (j + 1) % len;
                if (j == i) {
                    return i;
                }
            }
            //当最后一个站点也无法绕站一周
            if (j < i) {
                return -1;
            }
            //i-j 之间的所有站点都不能绕站一周，因此直接跳到i=j，然后i++
            i = j;
        }
        return -1;
    }


}
