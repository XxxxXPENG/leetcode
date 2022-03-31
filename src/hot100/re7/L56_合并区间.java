package hot100.re7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int leftPre = intervals[0][0], rightPre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (left <= rightPre) {
                rightPre = Math.max(rightPre, right);
            } else {
                list.add(new int[]{leftPre, rightPre});
                leftPre = left;
                rightPre = right;
            }
        }
        list.add(new int[]{leftPre, rightPre});
        return list.toArray(new int[0][]);
    }
}
