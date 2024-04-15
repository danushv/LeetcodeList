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
    int result=0;
    public int sumNumbers(TreeNode root) {
      helper(root,0);
      return result;
       

    }
    public int helper(TreeNode root,int ans)
{
        if(root!=null)
        {
        ans=(ans*10)+root.val;
        if(root.left==null&&root.right==null)
        {
            result=result+ans;
        }
        helper(root.left,ans);
        helper(root.right,ans);
        }
        return result;
}
}
