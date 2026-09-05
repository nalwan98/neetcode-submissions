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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null; // Base case: if either array is empty, return null
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==preorder[0]){
                mid = i;
                break;
            }
        }
        int[] leftpre = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftin = Arrays.copyOfRange(inorder,0, mid);
        int[] rightpre = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightin = Arrays.copyOfRange(inorder,mid+1, inorder.length);
        root.left = buildTree(leftpre, leftin);
        root.right = buildTree(rightpre, rightin);
        return root;
    }
}
