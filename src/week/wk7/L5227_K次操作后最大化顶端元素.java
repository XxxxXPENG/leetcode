package week.wk7;

public class L5227_K次操作后最大化顶端元素 {
    public int maximumTop(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) {
            return k % 2 == 1 ? -1 : nums[0];
        }
        if(k == 0 || k == 1) {
            return nums[k];
        }
        int[] maxArr = new int[len];
        maxArr[0] = nums[0];
        for(int i = 1; i < len; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
        }
        if(k > len) {
            return maxArr[len - 1];
        }
        if(k == len) k = len - 2;
        // 最终要比较其实是最后一次操作的抉择,此时nums[k-2]已出栈,栈顶为nums[k-1]
        // 两种选择:1.继续弹出nums[k-1],那么最终栈顶为nums[k]
        //         2.放当前最大的元素进栈顶,那么此时栈顶为maxArr[k-2]
        // 两者中取大的值
        return Math.max(nums[k], k < 2 ? maxArr[0] : maxArr[k - 2]);
    }
}
