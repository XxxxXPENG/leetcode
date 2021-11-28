package tree.morris;

import tree.TreeNode;

import java.util.*;

public class FindMode {
    List<Integer> list = new ArrayList<>();
    int count,maxCount, preVal;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val) {
        if (val == preVal) {
            count++;
        }else{
            count = 1;
            preVal = val;
        }
        if (count == maxCount) {
            list.add(preVal);
        }
        if(count > maxCount){
            maxCount = count;
            list.clear();
            list.add(preVal);
        }

    }
}
