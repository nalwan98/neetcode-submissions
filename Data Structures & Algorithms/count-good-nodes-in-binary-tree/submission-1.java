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
    int res = 0;
    public int goodNodes(TreeNode root) {
        if(root!=null){
            res++;
        }
        checknode(root.left, root.val);
        checknode(root.right, root.val);
        return res;
    }
    public void checknode(TreeNode root, int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            res++;
        }
         checknode(root.left, Math.max(max, root.val));
        checknode(root.right, Math.max(max, root.val));
        return;
    }
}
