package leetcode.medium.tree;

import leetcode.medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBT {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.left != null){
                if(flag) return false;
                queue.add(node.left);
            }else{
                flag = true;
            }
            if(node.right != null){
                if(flag) return false;
                queue.add(node.right);
            }else{
                flag = true;
            }
        }
        return true;

    }
}
