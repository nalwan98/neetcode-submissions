/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(currsubtree(root, subRoot)){
            return true;
        }
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean currsubtree(TreeNode root, TreeNode rootq){
        if(root==null && rootq==null){
            return true;
        }
        if(root==null || rootq==null){
            return false;
        }
        return root.val == rootq.val && currsubtree(root.right, rootq.right) && currsubtree(root.left, rootq.left);
    }
}
