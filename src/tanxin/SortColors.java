package tanxin;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {

        sortColors(new int[]{2,0,2,1,0,1});
    }

    public static void sortColors(int[] nums) {

        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                --right;
            }
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }

    }


}
