package sf.arr;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        int count = 0, num = 0;
        for (int i = 0; i < nums.length; i++){
            if(count == 0){
                num = nums[i];
                count = 1;
            }else
           count = num == nums[i] ? count + 1 : count + 1;
        }
        list.add(num);
        count = 0;
        for (int i = 0; i < nums.length;i++){
            if(nums[i] == list.get(0)) continue;
            else if(count == 0){
                num = nums[i];
                count = 1;
            }else
            count = num == nums[i] ? count + 1 : count + 1;
        }
        if(count > nums.length/3)   list.add(num);
        return list;
    }
}
