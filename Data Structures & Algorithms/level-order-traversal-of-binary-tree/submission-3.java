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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        if(root!=null){
            q.add(root);
        }
        while(q.size()!=0){
            int cursize=q.size(); 
            List<Integer> cur = new ArrayList<>();
            for(int i=0; i<cursize; i++){
                TreeNode curroot = q.poll();
                cur.add(curroot.val);
                if(curroot.left!=null){
                    q.add(curroot.left);
                }
                if(curroot.right!=null){
                    q.add(curroot.right);
                }
            }
            res.add(cur);
        }
        return res;
    }
}
