package hot100;

import java.util.Arrays;

public class L34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        L34_在排序数组中查找元素的第一个和最后一个位置 a = new L34_在排序数组中查找元素的第一个和最后一个位置();
        System.out.println(Arrays.toString(a.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = getIndex(nums, target, true);
        int right = getIndex(nums, target, false);
        return new int[]{left, right};
    }


    public int getIndex(int[] nums, int target, boolean isLeft) {
        int len = nums.length, left = 0, right = len - 1;
        boolean find = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //找到最左
            if (isLeft) {
                if (nums[mid] >= target) {
                    if (nums[mid] == target) {
                        find = true;
                    }
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右端
                if (nums[mid] <= target) {
                    if (nums[mid] == target) {
                        find = true;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (find) {
            return isLeft ? left : right;
        }
        return -1;
    }
}
