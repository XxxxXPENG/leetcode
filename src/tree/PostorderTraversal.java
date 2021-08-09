package tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    public void  postorder(List<Integer> res,TreeNode root){
        if(root == null){
            return;
        }
        postorder(res,root.left);
        postorder(res,root.right);
        res.add(root.val);
    }
}
