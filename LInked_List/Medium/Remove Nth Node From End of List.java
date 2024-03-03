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
           int maxDepth=0; // depth of the bottom level of the tree
        int bottomLeftValue=0; // store the leftmost calue in the last row of the three 
    public int findBottomLeftValue(TreeNode root) {
         maxDepth=-1; // depth of the bottom level of the tree
         bottomLeftValue=0; // store the leftmost calue in the last row of the three
        dfs(root,0);
        return bottomLeftValue;
    }
    
        // how to implement dfs function??
       public void dfs(TreeNode current,int depth)
        {
            if(current==null)
            return;

            if(depth>maxDepth) // this means we have found the new level
            {
                maxDepth=depth;
                bottomLeftValue=current.val;
            }
            dfs(current.left,depth+1);
            dfs(current.right,depth+1);

        }
        
}
