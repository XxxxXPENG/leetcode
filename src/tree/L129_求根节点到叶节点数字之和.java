package tree;

public class L129_求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        L129_求根节点到叶节点数字之和 a = new L129_求根节点到叶节点数字之和();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(a.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pre) {
        if (root == null) {
            return pre;
        }
        int sum = pre * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum)+ dfs(root.right, sum);
    }
}
