package hot100.re15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int leftPre = intervals[0][0], rightPre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (rightPre >= intervals[i][0]) {
                rightPre = Math.max(rightPre, intervals[i][1]);
            } else {
                res.add(new int[]{leftPre,rightPre});
                rightPre = intervals[i][1];
                leftPre = intervals[i][0];
            }
        }
        res.add(new int[]{leftPre, rightPre});
        return res.toArray(new int[0][]);
    }
}
