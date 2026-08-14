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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode node=root;
        q.offer(node);
        boolean normal=true;
        while(!q.isEmpty()){
            List<Integer>level=new ArrayList<>();
            int l=q.size();
            
            while(l>0){
                node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                l--;
                level.add(node.val);
            }
            if(!normal){
                Collections.reverse(level);
            }
            ans.add(level);
            normal=!normal;
        }
        return ans;
    }
}