package twoPointer.same;


public class RemoveDuplicates2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (idx < 2 || nums[idx - 2] < num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    int process(int[] nums, int k) {
        int idx = 0;
        for (int num : nums) {
            //数组中不允许一个数重复k+1次
            // 也就是说可以，小于k个连续数字相同时可以放入数组
            if (idx < k || nums[idx - k] != num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }
}
