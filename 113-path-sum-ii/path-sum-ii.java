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
    public List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path=new ArrayList<>();
        dfs(root,0,targetSum,path);
        return result;
    }
    public void dfs(TreeNode root, int sum, int target, List<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null && sum==target){
            result.add(new ArrayList<>(path));
        }
        else{
            dfs(root.left,sum,target,path);
            dfs(root.right,sum,target,path);
        }
        path.remove(path.size()-1);
    }
}