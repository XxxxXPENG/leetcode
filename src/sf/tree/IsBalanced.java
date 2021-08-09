package sf.tree;

/**
 * 判断是否是 平衡二叉树?
 * 那么它得是一个  满二叉树
 */
public class IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        if(left == -1)  return -1;
        int right = getDepth(root.right);
        if(right == -1) return -1;
        return Math.abs(left-right) >= 1 ? -1 : 1+Math.max(left,right);  //后面为什么要加左右的大者
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}