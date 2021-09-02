package tanxin.arr;

/**
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * 实例：
 *
 * 输入：nums = [2,1,5,0,4,6]
 * 输出：true
 * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 */

public class IncreasingTriplet {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,5,1,6}));
    }

    public static boolean increasingTriplet2(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > two) {
                return true;
            } else if (three <= one) {
                one = three;
            } else {
                two = three;
            }
        }
        return false;

    }


        public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int right = len - 1;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] < nums[right]) {
                for (int j = i + 1; j < right; j++) {
                    if (nums[j] > nums[i] && nums[j] < nums[right]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
