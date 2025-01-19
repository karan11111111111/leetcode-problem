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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Helper method for recursion
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd,
                                     int[] inorder, int inorderStart, int inorderEnd) {
        // Base case: If the subarray is empty
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        
        // The first element in preorder is the root of the current subtree
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root in inorder array
        int rootIndexInOrder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInOrder = i;
                break;
            }
        }
        
        // Recursively build the left and right subtrees
        int leftSubtreeSize = rootIndexInOrder - inorderStart;
        
        // Build the left subtree
        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftSubtreeSize,
                                    inorder, inorderStart, rootIndexInOrder - 1);
        
        // Build the right subtree
        root.right = buildTreeHelper(preorder, preorderStart + leftSubtreeSize + 1, preorderEnd,
                                     inorder, rootIndexInOrder + 1, inorderEnd);
        
        return root;
    }
}
