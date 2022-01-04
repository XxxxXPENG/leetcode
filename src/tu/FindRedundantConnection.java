package tu;

public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int index1 = edge[0];
            int index2 = edge[1];
            if (find(parent, index1) != find(parent, index2)) {
                union(parent, index1, index2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }


    /**
     * 将index1集合合入index2
     *
     * @param parent
     * @param index1
     * @param index2
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        return parent[index] == index ? index : (parent[index] = find(parent, parent[index]));
    }

}
