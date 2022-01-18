package mid;

import java.util.Arrays;

public class L354_俄罗斯套娃信封问题 {

    public static void main(String[] args) {
        L354_俄罗斯套娃信封问题 a = new L354_俄罗斯套娃信封问题();
        System.out.println(a.maxEnvelopes(new int[][]{
                {2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400},
                {5, 250}, {6, 370}, {6, 360}, {7, 380}
        }));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
            }
        });

        int len = 1, n = envelopes.length;
        int[] w = new int[n + 1];
        int[] h = new int[n + 1];
        w[len] = envelopes[0][0];
        h[len] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            int[] envelope = envelopes[i];
            if (w[len] < envelope[0] && h[len] < envelope[1]) {
                w[len + 1] = envelope[0];
                h[++len] = envelope[1];
            } else if (w[len] > envelope[0] || h[len] > envelope[1]) {
                int left = 0, right = len, pos = 0;
                //找到最近的信封替换
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (w[mid] < envelope[0] || h[mid] < envelope[1]) {
                        pos = mid;
                        left = mid + 1;
                    } else if (w[mid] > envelope[0] || h[mid] > envelope[1]) {
                        right = mid - 1;
                    }
                }
                w[pos + 1] = envelope[0];
                h[pos + 1] = envelope[1];
            }
        }
        return len;
    }


}
