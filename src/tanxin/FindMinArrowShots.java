package tanxin;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > pos) {
                ans++;
                pos = point[1];
            }
        }
        return ans;
    }
    public static int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > pos) {
                ans++;
                pos = point[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 9}, {7, 12}, {3, 8}, {6, 8},
                {9, 10}, {2, 9}, {0, 9},
                {3, 9}, {0, 6}, {2, 8}};
//        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
//        System.out.println(Arrays.deepToString(arr));

        System.out.println(findMinArrowShots(arr));
        System.out.println(findMinArrowShots2(arr));
    }
}
