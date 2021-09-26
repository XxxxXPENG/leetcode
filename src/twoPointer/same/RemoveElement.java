package twoPointer.same;


import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
//        System.out.println(removeElement2(new int[]{3,2,2,3},3));
        System.out.println(removeElement2(new int[]{0,1,2,2,3,0,4,2},2));
    }


    public static int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

}
