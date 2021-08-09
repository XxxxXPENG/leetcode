package sf.binary;

import java.util.HashSet;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 */
public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }
    public static int singleNonDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       String res = "";
        for (int num : nums) {
            res += num;
        }

        for (int i = 0; i < nums.length; i++){
            System.out.println(res.indexOf(nums[i],i) == -1);
           if(! set.contains(nums[i]) && res.indexOf(nums[i],i) != -1)
               return nums[i];
               set.add(nums[i]);
        }
        return -1;
    }
}
