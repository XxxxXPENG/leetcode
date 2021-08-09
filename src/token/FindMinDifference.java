package token;

import java.util.Arrays;
import java.util.List;

public class FindMinDifference {
    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59","00:00")));
    }


    public static int findMinDifference(List<String> timePoints) {
        int[] minArr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            minArr[i] = countMinutes(timePoints.get(i));
        }
        int min = Integer.MAX_VALUE;
        Arrays.sort(minArr);
        for (int i = 1; i < timePoints.size(); i++) {
            min = Math.min(min, minArr[i] - minArr[i - 1]);
            if (min == 0) {
                return min;
            }
        }
        return Math.min(min, 1440 + minArr[0] - minArr[minArr.length - 1]);
    }

    public static int countMinutes(String s1) {
        return Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3));
    }
}
