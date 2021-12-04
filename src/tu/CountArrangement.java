package tu;

import java.util.ArrayList;
import java.util.List;

public class CountArrangement {

    public static void main(String[] args) {
        CountArrangement c = new CountArrangement();
        System.out.println(c.countArrangement(5));
    }

    List<Integer>[] match;
    boolean[] vis;
    int res;

    public  int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n+1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backTrack(1, n);
        return res;
    }

    private void backTrack(int index, int n) {
        if (index == n + 1) {
            res++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backTrack(index + 1, n);
                vis[x] = false;
            }
        }
    }
}
