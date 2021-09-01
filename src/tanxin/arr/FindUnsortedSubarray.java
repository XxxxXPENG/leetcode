package tanxin.arr;

import java.util.Arrays;

public class FindUnsortedSubarray {

    public static void main(String[] args) {
//        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
//        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));

//        System.out.println(findUnsortedSubarray(new int[]{2,3,3,2,4}));
        System.out.println(findUnsortedSubarray3(new int[]{2, 1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = 0, end = 0;
        boolean first = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i] && !first) {
                end = i;
            }
            if (nums[i - 1] > nums[i]) {
                swap(nums, i - 1, i);
                if (first) {
                    start = i - 1;
                    first = false;
                }
            }
        }
        return end == start ? 0 : end - start + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 排序
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = len - 1;
        while (i <= j && nums[i] == arr[i]) {
            i++;
        }
        while (i <= j && nums[j] == arr[j]) {
            j--;
        }
        return j - i + 1;
    }

    /**
     * 一次遍历
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray3(int[] nums) {
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i < j && nums[i + 1] >= nums[i]) {
            i++;
        }
        while (i < j && nums[j - 1] <= nums[j]) {
            j--;
        }
        int l = i, r = j;
        int min = nums[i], max = nums[j];
        for (int k = l; k <= r; k++) {
            if (min > nums[k]) {
                while (i >= 0 && nums[i] > nums[k]) {
                    i--;
                }
                min = i >= 0 ? nums[i] : MIN;
            }
            if (max < nums[k]) {
                while (j < len && nums[j] < nums[k]) {
                    j++;
                }
                max = j < len ? nums[j] : MAX;
            }
        }
        return j == i ? 0 : (j - 1) - (i + 1) + 1;
    }

}
