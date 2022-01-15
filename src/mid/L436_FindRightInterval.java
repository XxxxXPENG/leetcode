package mid;

import java.util.Map;
import java.util.TreeMap;

public class L436_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            res[i] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }
}
