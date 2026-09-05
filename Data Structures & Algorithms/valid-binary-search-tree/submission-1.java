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
    public boolean isValidBST(TreeNode root) {
        return helper(root, -1010, 1010);
    }
    private boolean helper(TreeNode root, int leftmax, int rightmax){
        if(root==null){
            return true;
        }
        return root.val>leftmax && root.val<rightmax && helper(root.left, leftmax, root.val) && helper(root.right, root.val, rightmax);
    }
}
