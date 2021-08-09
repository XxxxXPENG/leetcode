package arr;

public class FindMaxConsecutiveOnes {
    /**
     * 最大连续1的个数.
     * 输入：[1,1,0,1,1,1]
     * 输出：3
     * @param nums
     * @return
     */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
               count++;
            }else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return  Math.max(max, count);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
