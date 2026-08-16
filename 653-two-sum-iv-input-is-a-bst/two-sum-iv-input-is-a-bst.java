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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>list=inorder(root);
        int low=0;
        int high=list.size()-1;
        while(low<high){
            int sum=list.get(low)+list.get(high);
            if(sum==k){
                return true;
            }
            if(sum<k){
                low++;
            }
            if(sum>k){
                high--;
            }
        }
        return false;

    }
    public List<Integer> inorder(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        inordertrav(root,ans);
        return ans;
    }
    public void inordertrav(TreeNode root, List<Integer> ans){
        if(root==null){
            return;
        }
        inordertrav(root.left,ans);
        ans.add(root.val);
        inordertrav(root.right,ans);
    }

}