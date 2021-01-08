/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        map.put(root, null);
        Q.add(root);
        
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode curr = Q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                Q.add(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                Q.add(curr.right);
            }
        }
        
        while (p != null) {
            list.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (list.contains(q))
                return q;
            q = map.get(q);
        }
        return null;
    }
}
