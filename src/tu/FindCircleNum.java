package tu;

/**
 * 图的最大联通量
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(visited, isConnected, i);
            }
        }
        return res;
    }

    private void dfs(boolean[] visited, int[][] isConnected, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(visited, isConnected, j);
            }
        }
    }


    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }

        class UnionFind {
        int[] roots;
        int size;

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            size = n;
        }

        public int find(int i) {
            return i == roots[i] ? i : (roots[i] = find(roots[i]));
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                roots[pRoot] = qRoot;
                size--;
            }
        }
    }

}
