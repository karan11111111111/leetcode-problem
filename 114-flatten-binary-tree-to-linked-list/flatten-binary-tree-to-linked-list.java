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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // If there is a left child, move it to the right and set left to null
        if (root.left != null) {
            TreeNode temp = root.right;  // Save the original right child
            root.right = root.left;      // Move the left child to the right
            root.left = null;            // Set left to null
            // Find the rightmost node of the new right subtree
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            // Attach the original right child to the rightmost node
            current.right = temp;
        }
    }
}
