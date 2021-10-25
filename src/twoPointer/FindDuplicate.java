package twoPointer;

/**
 * 给定数组，n+1个数，每个数都在1-n中，求重复数字
 * <p>
 * 不能改变数组，且不借用额外空间
 */
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
