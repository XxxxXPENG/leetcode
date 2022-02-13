package week.wk3;

import java.util.HashMap;
import java.util.Map;

public class L6005_使数组变成交替数组的最少操作数 {
    public int minimumOperations(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 1) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            } else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }
        //计算 max1 max2
        int max1 = 0, mmax1 = 0, max2 = 0, mmax2 = 0, count1 = 0, count2 = 0;
        int max1Num = 0;
        for (Integer key : map1.keySet()){
            count1 += map1.get(key);
            if(max1 < map1.get(key)){
                mmax1 = max1;
                max1 = map1.get(key);
                max1Num = key;
            }else if(mmax1 < map1.get(key)){
                mmax1 = map1.get(key);
            }
        }
        int max2Num = 0;
        for (Integer key : map2.keySet()){
            count2 += map2.get(key);
            if(max2 < map2.get(key)){
                mmax2 = max2;
                max2 = map2.get(key);
                max2Num = key;
            }else if(mmax2 < map2.get(key)){
                mmax2 = map2.get(key);
            }
        }
        if(max1Num != max2Num){
            return len - max1 - max2;
        }else {
            return Math.min((count1 - mmax1 + count2 - max2),(count1 - max1 + count2 - mmax2));
        }

    }
}
