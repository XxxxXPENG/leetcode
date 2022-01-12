package mid;

import java.util.Arrays;

public class L34_searchRange {
    public static void main(String[] args) {
        L34_searchRange a = new L34_searchRange();
        System.out.println(Arrays.toString(a.searchRange(new int[]{2,2}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                for (int i = mid; i >=0 && nums[i] == target ; i--) {
                    res[0] = i;
                }
                for (int i = mid;  i < nums.length-1 && nums[i] == target ; i++) {
                    res[1] = i+1;
                }
                return res;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
