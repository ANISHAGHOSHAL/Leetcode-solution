class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        Map<Integer,ArrayList<TreeNode>> map=new HashMap<>();
        helper(map,1,root);
        map.get(depth-1).forEach(item->{
            TreeNode left=item.left,right=item.right;
            item.left=new TreeNode(val);
            item.left.left=left;
            item.right=new TreeNode(val);
            item.right.right=right;
        });
        // System.out.println(map);
        return root;
    }
    private void helper(Map<Integer,ArrayList<TreeNode>> map,int level,TreeNode node){
        if(node==null) return;
        if(map.containsKey(level)){
            map.get(level).add(node);
        }else map.put(level,new ArrayList<>(Arrays.asList(node)));
        helper(map,level+1,node.left); 
        helper(map,level+1,node.right);
    }
}