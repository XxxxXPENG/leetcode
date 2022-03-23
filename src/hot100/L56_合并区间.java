package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_合并区间 {

    public static void main(String[] args) {
        L56_合并区间 a = new L56_合并区间();
        System.out.println(Arrays.deepToString(a.merge(new int[][]{
                {1,4},  {2, 3}
        })));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int leftPre=intervals[0][0],rightPre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int left = interval[0], right = interval[1];
            if (rightPre >= left) {
                rightPre = Math.max(right,rightPre);
            } else {
                res.add(new int[]{leftPre, rightPre});
                leftPre = left;
                rightPre = right;
            }
        }
        res.add(new int[]{leftPre,rightPre});
        return res.toArray(new int[0][]);

    }
}
