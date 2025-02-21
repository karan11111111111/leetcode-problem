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
import java.util.HashSet;

class FindElements {
    private HashSet<Integer> values; // Stores recovered values for O(1) lookup

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0); // Start recovery with root = 0
    }

    private void recoverTree(TreeNode node, int value) {
        if (node == null) return;
        
        node.val = value;
        values.add(value); // Store the recovered value

        // Recursively assign values to left and right children
        recoverTree(node.left, 2 * value + 1);
        recoverTree(node.right, 2 * value + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */