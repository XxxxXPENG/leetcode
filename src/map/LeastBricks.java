package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, sum = 0; i < n; i++, sum = 0) {
            for (int cur : wall.get(i)) {
                sum += cur;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }

        int ans = n;
        for (int i : map.values()) {
            ans = Math.min(ans, n - i);
        }
        return ans;
    }
}
