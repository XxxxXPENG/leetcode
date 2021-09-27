package twoPointer.same;


public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }


    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 1, right = 1;
        while (right < len) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

}
