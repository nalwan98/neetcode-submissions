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
    public int goodNodes(TreeNode root) {
        return goodNodesMax(root, -110);
    }
    private int goodNodesMax(TreeNode root, int maxparent){
        if(root==null){
            return 0;
        }
        if(maxparent<=root.val){
            return 1 + goodNodesMax(root.left , Math.max(maxparent, root.val)) + goodNodesMax(root.right , Math.max(maxparent, root.val));
        }
        else{
            return goodNodesMax(root.left , Math.max(maxparent, root.val)) + goodNodesMax(root.right , Math.max(maxparent, root.val));
        }

    }

}
