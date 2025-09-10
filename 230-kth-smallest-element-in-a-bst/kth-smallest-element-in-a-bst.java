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
// class Solution {
//     private int count = 0;
//     private int result = 0;

//     public int kthSmallest(TreeNode root, int k) {
//         inorder(root, k);
//         return result;
//     }

//     private void inorder(TreeNode node, int k) {
//         if (node == null) return;

//         inorder(node.left, k); // traverse left subtree

//         count++;
//         if (count == k) {
//             result = node.val;
//             return;
//         }

//         inorder(node.right, k); // traverse right subtree
//     }
// }


import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            // go to leftmost node
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            k--;
            if (k == 0) return node.val; // found kth smallest

            node = node.right;
        }

        return -1; // k is invalid
    }
}
