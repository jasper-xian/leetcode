/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
	    int inStart = 0;
	    int inEnd = inorder.length - 1;
	    int postStart = 0;
	    int postEnd = postorder.length - 1;
 
	    return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
 
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
		    int[] postorder, int postStart, int postEnd) {
	    if (inStart > inEnd || postStart > postEnd)
		    return null;
 
	    int rootValue = postorder[postEnd];
	    TreeNode root = new TreeNode(rootValue);
 
	    int index = 0;
	    for (int i = 0; i < inorder.length; i++) {
		    if (inorder[i] == rootValue) {
			    index = i;
			    break;
		    }
	    }
 
	    root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + index - (inStart +                                 1));
	    root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1);
	    return root;
    }
}
