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
        ArrayList<Integer> a = new ArrayList<Integer>();
        traverse(root,a,0);
        return a;
    }
    
    private void traverse(TreeNode root,ArrayList<Integer> a,int c)
    {
        if(root==null)
            return;
        if(c==a.size())    //level no. should be equal to index no. in list
        a.add(root.val);
        traverse(root.right,a,c+1);
        traverse(root.left,a,c+1);
    }
}