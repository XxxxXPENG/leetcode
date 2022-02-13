package week.wk3;

import java.util.Arrays;

public class L6006_拿出最少数目的魔法豆 {
    public static void main(String[] args) {
        int a = 999999;
        int len = 1000000000;
        long res = len * a;
        System.out.println(res);
        System.out.println(len * (long) a);
    }

    /**
     * 要求取出豆子最少 -> 剩下最多豆子
     * 将数组从小到大排序，
     * 对于i位置剩下最多豆子方程为： (len - i) * beans[i]
     * @param beans
     * @return
     */
    public long minimumRemoval2(int[] beans) {
        Arrays.sort(beans);
        int len = beans.length;
        long sum = 0, maxLeft = 0;
        for (int i = 0; i < len; i++) {
            sum += beans[i];
            //为什么beans[i] 就转为long
            long leftBeans = (len - i) * (long) beans[i];
            maxLeft = Math.max(maxLeft, leftBeans);
        }
        return sum - maxLeft;
    }


    public long minimumRemoval(int[] beans) {
        long res = 0;
        int cut = 0, d = 0,sum=0;
        Arrays.sort(beans);
        int len = beans.length;
        int pre = beans[len - 1];
        for (int i = len-2; i >=0 ; i--) {
            if (beans[i] != 0 && beans[i] < pre) {
                cut += pre - beans[i];
                d = beans[i];
                sum = Math.min(cut, d);
                if (d > cut) {
                    pre = beans[i];
                }
                res += sum;
            }
        }
        return res;
    }
}
