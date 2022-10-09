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
    HashSet<Integer> table = new HashSet<>();
    
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    
    while(!list.isEmpty()){
      root = list.pollFirst();
      if(table.contains(k - root.val)) return true;
      table.add(root.val);
      
      if(root.left  != null) list.addLast(root.left);
      if(root.right != null) list.addLast(root.right);
    }
    
    return false;
  }
}