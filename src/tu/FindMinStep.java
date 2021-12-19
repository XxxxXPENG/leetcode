package tu;

import java.util.HashMap;
import java.util.Map;

public class FindMinStep {
    int INF = 0x3f3f3f3f;
    String b;
    int m;
    Map<String, Integer> map = new HashMap<>();

    class Node {
        String a;
        int cur, val, step;
        Node (String _a, int _c, int _v, int _s) {
            a = _a;
            cur = _c; val = _v; step = _s;
        }
    }
    int f(String a, int k) {
        Map<Character, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            m1.put(a.charAt(i), m1.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) == 0) {
                m2.put(b.charAt(i), m2.getOrDefault(b.charAt(i), 0) + 1);
            }
        }
        int ans = 0;
        for (char c : m1.keySet()) {
            int c1 = m1.get(c), c2 = m2.getOrDefault(c, 0);
            if (c1 + c2 < 3) return INF;
            if (c1 < 3) ans += (3 - c1);
        }
        return ans;

    }

    public int findMinStep(String board, String hand) {
        return 0;
    }
}
