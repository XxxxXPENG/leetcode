package arr;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.找到出现频率最多的数，
 * 2.如果有多个，返回最短连续长度
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        /**
         *  第1位记录出现频率，
         *  第2，3位记录出现的始末位置
         */
        Map<Integer, int[]> map = new HashMap<>(12);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        //寻找数组2，3 差值最小的
        int max = 0, minLen = nums.length;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (max < arr[0]) {
                max = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (max == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }
}
