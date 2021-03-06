/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val)
            return root;
        if (root.left == null && val < root.val)
            return null;
        if (root.right == null && val > root.val)
            return null;
        if (root.left != null && val < root.val)
            return searchBST(root.left, val);
        if (root.right != null && val > root.val)
            return searchBST(root.right, val);
        return null;
    }
}
