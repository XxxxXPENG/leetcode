package sf.arr;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length,res = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2) res = entry.getKey();
        }
        return res;
    }

    // 解法二

//    int count = 0, num = 0;
//        for (int i = 0; i < nums.length; i++){
//        if(count == 0){
//            num = nums[i];
//            count = 1;
//        }
//        count = num == nums[i] ? count + 1 : count + 1;
//    }
}
