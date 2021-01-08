/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = inorderTraversal(root);
        for (int i=0; i<list.size()-1; i++) {
            if (list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            if (list.isEmpty())
                return list;
            else
                return null;
        }
        List<Integer> left = inorderTraversal(root.left);
        list.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        return list;
    }
}
