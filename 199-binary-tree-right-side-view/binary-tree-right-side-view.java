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
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int levelSize = queue.size();
//             for (int i = 0; i < levelSize; i++) {
//                 TreeNode currentNode = queue.poll();

//                 // If it's the last node in the current level, add it to the result
//                 if (i == levelSize - 1) {
//                     result.add(currentNode.val);
//                 }

//                 // Add left and right children to the queue
//                 if (currentNode.left != null) {
//                     queue.offer(currentNode.left);
//                 }
//                 if (currentNode.right != null) {
//                     queue.offer(currentNode.right);
//                 }
//             }
//         }

//         return result;
//     }
// }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If the current depth is greater than the size of the result, add the node
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Recur on the right child first to ensure rightmost nodes are processed first
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
