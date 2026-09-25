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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(q.size()!=0){
            int cursize = q.size();
            for(int i=0; i<cursize; i++){
                TreeNode curtree = q.poll();
                if(i==cursize-1){
                    res.add(curtree.val);
                }
                if(curtree.left!=null){
                    q.add(curtree.left);
                }
                if(curtree.right!=null){
                    q.add(curtree.right);
                }
            }
        }
        return res;
    }
}
