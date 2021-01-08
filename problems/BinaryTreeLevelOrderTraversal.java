/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> roots = new LinkedList<TreeNode>();
        Queue<TreeNode> stems = new LinkedList<TreeNode>();
        if (root == null)
            return result;
        roots.add(root);

        List<Integer> list = new ArrayList<Integer>();
        
        while (!roots.isEmpty()) {
            TreeNode curr = roots.poll();
            list.add(curr.val);
            if (curr.left != null) {
                stems.add(curr.left);
            }
            if (curr.right != null) {
                stems.add(curr.right);
            }
            if (roots.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                roots = stems;
                stems = new LinkedList<TreeNode>();
            }
        }
        return result;
        
    }
}
