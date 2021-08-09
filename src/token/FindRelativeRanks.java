package token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        int index = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) {
                ans[map.get(score[i])] = "Gold Medal";
            } else if (i == score.length - 2) {
                ans[map.get(score[i])] = "Silver Medal";
            } else if (i == score.length - 3) {
                ans[map.get(score[i])] = "Bronze Medal";
            } else {
                ans[map.get(score[i])] = Integer.toString(index + 1);
            }
            index++;
        }
        return ans;
    }
}
