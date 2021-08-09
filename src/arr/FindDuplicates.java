package arr;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

    public  List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            while(nums[nums[i] - 1] != nums[i]){
                swap(nums,i , nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]-1 != i){
                res.add(nums[i]);
            }
        }
        return res;
    }


    public void swap(int[] nums,int index1,int index2){
        if(nums == null){
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }
}
