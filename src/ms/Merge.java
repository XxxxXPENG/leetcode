package ms;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[][] arr2 = {{1, 4}, {2,3}};
        System.out.println(Arrays.deepToString(merge(arr2)));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null) return new int[][]{};
        if(intervals.length == 1) return intervals;
        int[][] res = new int[intervals.length][];
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        int[] pre = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= pre[1]) {
                pre[1] = cur[1];
            } else {
                res[index++] = pre;
                pre = cur;
            }
            if (i == intervals.length - 1) {
                res[index++] = pre;
            }
        }
        return Arrays.copyOf(res,index);
    }
}
