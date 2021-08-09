package ms;

import java.util.HashMap;
import java.util.Map;

public class Fblj {
    public static void main(String[] args) {
        System.out.println(fb(10));
        System.out.println(fb_better(10));
        System.out.println(fb2(10));
    }

    public static Map<Integer, Integer> map = new HashMap<>();
    public static int fb_better(int n) {

        if (n == 0) {
            map.put(0, 0);
            return 0;
        } else if (n == 1) {
            map.put(1, 1);
            return 1;
        } else if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = fb_better(n - 1) + fb_better(n - 2);
        map.put(n, res);
        return res;
    }


    public static int fb(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fb(n - 1) + fb(n - 2);
    }


    public static int fb2(int n) {
        if (n < 2) {
            return n;
        }
        int sum=0, n1 = 0, n2 = 1;
        for (int i = 2; i <= n; i++) {
            sum = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
}
