class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root,limit,0)?null:root;
    }
    
    boolean dfs(TreeNode root,int limit,int sum)
    {
        if(root==null)
        {
            return true;
        }
        if(root.left==null && root.right==null)
        {
            if(sum+root.val<limit)
            {
                return true;
            }
            return false;
        }
        boolean left = dfs(root.left,limit,sum+root.val);
        boolean right = dfs(root.right,limit,sum+root.val);
        if(left)
            root.left = null;
        if(right)
            root.right = null;
        return left&right;
    }
}
