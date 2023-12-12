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
 /*
 Algorithm 
 1. When Array is  sorted always think about BST
 2. Middle element as the root node 
 3 Then the root for the left subtree will be middle element of left part of array
 4 similar case for right part too.
 5. use recurssion and helper function to do soo .
 6. Also the above part of the code TreeNode is a constructor.
 file that can hold papers
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return ContructTreeNodeFromArray(nums,0,nums.length-1);
    }
    public TreeNode ContructTreeNodeFromArray(int []nums, int left , int right)
    {
        if(left>right)
        return null;
        int mid=left +(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=ContructTreeNodeFromArray(nums,left,mid-1);
        node.right=ContructTreeNodeFromArray(nums,mid+1,right);
        return node;
        




    }
}
