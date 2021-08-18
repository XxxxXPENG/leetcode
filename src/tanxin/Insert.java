package tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newArr = {4, 8};
        int[][] res = insert2(arr, newArr);
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

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean placed = false;
        for (int[] nums : intervals) {
            //原始插入的在新增的右侧，且无交集
            if (right < nums[0]) {
                if (!placed) {
                    res.add(new int[]{left, right});
                    placed = true;
                }
                res.add(nums);
            } else if (left > nums[1]) {
                //原始插入在左侧，且无交集
                res.add(nums);
            } else {
                left = Math.min(left, nums[0]);
                right = Math.max(right, nums[1]);
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[0][]);
    }
}
