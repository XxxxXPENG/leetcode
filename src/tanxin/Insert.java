package tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{6,9}};
        int[] newArr = {2, 5};
        int[][] res = insert(arr, newArr);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort((Comparator.comparingInt(o -> o[0])));
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < list.size()) {
            int left = list.get(i)[0];
            int right = list.get(i)[1];
            while (i < list.size() - 1 && right >= list.get(i + 1)[0]) {
                i++;
                right = Math.max(right, list.get(i)[1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
