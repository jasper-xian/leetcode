/*
Given a binary tree, populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> roots = new LinkedList<Node>();
        Queue<Node> stems = new LinkedList<Node>();
        if (root == null)
            return null;
        roots.add(root);
        
        while (!roots.isEmpty()) {
            Node curr = roots.poll();
            curr.next = roots.peek();
            if (curr.left != null) {
                stems.add(curr.left);
            }
            if (curr.right != null) {
                stems.add(curr.right);
            }
            if (roots.isEmpty()) {
                roots = stems;
                stems = new LinkedList<Node>();
            }
        }
        return root;
    }
}
