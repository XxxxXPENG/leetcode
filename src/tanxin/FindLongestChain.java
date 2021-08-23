package tanxin;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

    public static void main(String[] args) {
        int[][] arr = {{-9,8}, {-6,9}, {1,6},{-1,4},{-6,-2},{-5,3},{0,3},{8,10}};
        System.out.println(findLongestChain(arr));
    }

    public static int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(pairs));


        int ans = 1;
        int right = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > right) {
                ans++;
                right = pairs[i][1];
            }
        }
        return ans;
    }
}
