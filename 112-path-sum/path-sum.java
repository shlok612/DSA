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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        Stack<TreeNode> path=new Stack<>();
        Stack<Integer> sum=new Stack<>();
        path.push(root);
        sum.push(root.val);

        while(!path.isEmpty()){
            TreeNode temp=path.pop();
            if(temp==null){
                continue;
            }
            int s=sum.pop();
            if(temp.right==null && temp.left==null && s==targetSum){
                return true;
            }
            if(temp.left!=null){
                path.push(temp.left);
                sum.push(s+temp.left.val);
            }
            if(temp.right!=null){
                path.push(temp.right);
                sum.push(s+temp.right.val);
            }
        }
        return false;
    }
}