package arr.moveArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotate {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < k; i++) {
            Integer tail = list.remove(len-1);
            list.add(0, tail);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums));
    }


    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
