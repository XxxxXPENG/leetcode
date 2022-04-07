package hot100.re2;

import java.util.HashMap;
import java.util.Map;

public class L96_不同的二叉搜索树 {
    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i-1);
            int rightNum = numTrees(n - i);
            res += leftNum * rightNum;
        }
        map.put(n, res);

        return res;
    }
}
