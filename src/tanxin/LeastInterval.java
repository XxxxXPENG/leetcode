package tanxin;

import java.util.HashMap;
import java.util.Map;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0,maxCount = 0;
        for (Character c : tasks) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            maxExec = Math.max(count, maxExec);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxExec) {
                maxCount++;
            }
        }
        return (maxExec-1) * (n + 1) + maxCount;
    }
}
