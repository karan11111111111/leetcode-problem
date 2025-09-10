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

 //bruteforce
 
// class Solution {

//     private int preIndex = 0; // pointer for preorder array

//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         return build(preorder, inorder, 0, inorder.length - 1);
//     }

//     private TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
//         if (inStart > inEnd) return null;

        
//         int rootVal = preorder[preIndex++];
//         TreeNode root = new TreeNode(rootVal);

       
//         int inIndex = inStart;
//         while (inIndex <= inEnd && inorder[inIndex] != rootVal) {
//             inIndex++;
//         }

       
//         root.left = build(preorder, inorder, inStart, inIndex - 1);
//         root.right = build(preorder, inorder, inIndex + 1, inEnd);

//         return root;
//     }
// }


import java.util.*;

class Solution {

    private int preIndex = 0; // pointer for preorder array
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a hashmap for quick lookup of inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Current root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Get root index in inorder from hashmap (O(1))
        int inIndex = inorderIndexMap.get(rootVal);

        // Build left and right subtrees
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }
}
