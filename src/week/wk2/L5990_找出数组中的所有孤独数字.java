package week.wk2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L5990_找出数组中的所有孤独数字 {

    public static void main(String[] args) {
        L5990_找出数组中的所有孤独数字 a = new L5990_找出数组中的所有孤独数字();
        System.out.println(a.findLonely(new int[]{0}));
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        int len = nums.length;
        if (len == 1) {
            res.add(nums[0]);
            return res;
        }
        if (nums[0] != nums[1] && nums[0] + 1 != nums[1]) {
            res.add(nums[0]);
        }
        for (int i = 1; i < len-1; i++) {
            if (nums[i] != pre && nums[i] - 1 != pre && nums[i] != nums[i + 1] && nums[i] + 1 != nums[i + 1]) {
                res.add(nums[i]);
            }
            pre = nums[i];
        }
        if (nums[len - 1] != nums[len-2] && nums[len - 1] -1!= nums[len-2]) {
            res.add(nums[len - 1]);
        }
        return res;
    }
}
