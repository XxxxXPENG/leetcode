package hot100.re2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int leftPre = intervals[0][0], rightPre = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (rightPre >= left) {
                rightPre = Math.max(rightPre, right);
            } else {
                res.add(new int[]{leftPre, rightPre});
                leftPre = left;
                rightPre = right;
            }
        }
        res.add(new int[]{leftPre, rightPre});
        return res.toArray(new int[0][]);
    }
}
