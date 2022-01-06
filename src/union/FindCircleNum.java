package union;

public class FindCircleNum {
    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        int[][] arr = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum.findCircleNum(arr));
    }


    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        Union union = new Union(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.size;
    }

    private class Union{
        private int[] roots;
        private int size;
        public Union(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
            size = n;
        }
        public int find(int i){
            return roots[i] == i ? i : (roots[i] = find(roots[i]));
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
