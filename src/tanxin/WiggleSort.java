package tanxin;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        wiggleSort2(new int[]{1,3,2,2,3,1});
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int i = 1, j = len / 2 + 1;
        while (j < len) {
            swap(nums, i, j++);
            i += 2;
        }
    }


    public static void wiggleSort2(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int len = help.length;
        for (int i = 1; i < nums.length; i+=2) {
            nums[i] = help[--len];
        }

        for (int i = 0; i < nums.length; i+=2) {
            nums[i] = help[--len];
        }
    }

        public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
