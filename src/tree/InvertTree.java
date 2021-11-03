package tree;

import java.util.LinkedList;

public class InvertTree {
    public TreeNode invertTree2(TreeNode root){
        if (root == null) {
            return null;
        }
        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //一次遍历剩余节点
        invertTree2(root.left);
        invertTree2(root.right);

        return root;
    }



    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return null;
        }

        linkedList.add(root);

        while (!linkedList.isEmpty()) {
            /**
             * 交换左右节点
             */
            TreeNode temp = linkedList.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;

            if (temp.left != null) {
                linkedList.add(temp.left);
            }
            if (temp.right != null) {
                linkedList.add(temp.right);
            }
        }
        return root;
    }
}