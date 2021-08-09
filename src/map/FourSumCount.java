package map;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int u : nums1) {
            for (int v : nums2) {
                map.put(u + v, map.getOrDefault(u + v, 0) + 1);
            }
        }
        int res = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (map.containsKey(-u - v)) {
                    res += map.get(-u - v);
                }
            }
        }
        return res;
    }
}
