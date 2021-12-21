package backTrack;

import java.util.*;

public class GetPermutation {

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(3,3));
    }


    int n;
    int k;
    boolean[] used;
    /**
     * 阶乘数组（剪枝）
     */
    private int[] factorial;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        calculateFactorial(n);

        used = new boolean[n + 1];
        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }

    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            return;

        }
    }

    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1]*i;
        }
    }


    public String getPermutation2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        dfs(res, path, vis, n);
        StringBuilder sb = new StringBuilder();
        List<Integer> list = res.get(k-1);
        for (Integer s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, boolean[] vis, int len) {
        if (len == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path.add(i+1);
                dfs(res, path, vis,len);
                path.removeLast();
                vis[i]=false;
            }
        }

    }
}
