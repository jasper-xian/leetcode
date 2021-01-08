/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree.
There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        List<String> list = new ArrayList<String>();
        Q.offer(root);
        
        while (!Q.isEmpty()) {
            TreeNode curr = Q.poll();
            if (curr == null) {
                list.add("null");
            }
            else {
                list.add(Integer.toString(curr.val));
                Q.offer(curr.left);
                Q.offer(curr.right);
            }
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        int index = 1;
        
        while (!Q.isEmpty() && index < arr.length) {
            TreeNode curr = Q.poll();
            if (!arr[index].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[index]));
                Q.offer(curr.left);
            }
            else
                curr.left = null;
            index++;
            
            if (!arr[index].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[index]));
                Q.offer(curr.right);
            }
            else
                curr.right = null;
            index++;
        }
        return root;
    }
}
