package sf.dp;

import java.util.Arrays;

public class FindNumberOfLIS {
    /**
     * 最长子序列的个数。
     * [1,3,5,4,7]
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        int[] count = new int[5];
        Arrays.fill(count,1);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{}));
    }
}
