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

 // brute force-1
// class Solution {
//     public int maxPathSum(TreeNode root) {
//         if (root == null) return 0;
//         int[] max = {Integer.MIN_VALUE};
//         helper(root, max);
//         return max[0];
//     }

//     private void helper(TreeNode node, int[] max) {
//         if (node == null) return;

//         // Compute all path sums starting from this node
//         int localMax = maxPathFrom(node);

//         // Update global maximum
//         max[0] = Math.max(max[0], localMax);

//         // Recurse on children
//         helper(node.left, max);
//         helper(node.right, max);
//     }

//     // Returns maximum path sum that passes through this node
//     private int maxPathFrom(TreeNode node) {
//         if (node == null) return 0;

//         int left = maxPathFrom(node.left);
//         int right = maxPathFrom(node.right);

//         // Best path can be:
//         // 1. Just the node
//         // 2. Node + left path
//         // 3. Node + right path
//         // 4. Node + left + right
//         return Math.max(node.val, 
//                Math.max(node.val + left,
//                Math.max(node.val + right,
//                         node.val + left + right)));
//     }
// }


//brute force-2

class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] max = {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    // For every node, compute local max using downward-only sums from children
    private void helper(TreeNode node, int[] max) {
        if (node == null) return;

        int leftDown  = Math.max(0, maxDownFrom(node.left));   // max sum starting at node.left going down
        int rightDown = Math.max(0, maxDownFrom(node.right));  // max sum starting at node.right going down

        int localMax = node.val + leftDown + rightDown;        // path that passes through node
        max[0] = Math.max(max[0], localMax);

        // recurse on children (brute-force)
        helper(node.left, max);
        helper(node.right, max);
    }

    // Returns maximum sum of a path that starts at 'node' and goes downward
    private int maxDownFrom(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxDownFrom(node.left));
        int right = Math.max(0, maxDownFrom(node.right));
        return node.val + Math.max(left, right);
    }
}
