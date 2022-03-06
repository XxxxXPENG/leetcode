package week.wk6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L6017_向数组中追加K个整数 {
    public static void main(String[] args) {
        L6017_向数组中追加K个整数 a = new L6017_向数组中追加K个整数();
        System.out.println(a.minimalKSum2(new int[]{1,4,25,10,25},2));
    }

    public long minimalKSum2(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 1,count;
        long res = 0;
        for (int i = 0; i < nums.length && k >= 0; i++) {
            if (start < nums[i]) {
                count = nums[i] - start >= k ? k : nums[i] - start;
                //等差求和，公差为1，末项为 start + count - 1
                res += (2L * start + count - 1) * count / 2;
                k-=count;
            }
            start = nums[i]+1;
        }
        //末项为k
        if (k > 0) {
            res += (2L * start + k - 1) * k / 2;
        }
        return res;
    }





    public long minimalKSum(int[] nums, int k) {
        long res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= Math.pow(10, 9) && k>0; i++) {
            if (!set.contains(i)) {
                res += i;
                k--;
                set.add(i);
            }
        }
        return res;
    }
}
