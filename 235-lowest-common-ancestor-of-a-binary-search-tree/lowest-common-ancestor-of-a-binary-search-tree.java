/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//brute force

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//        if(root == null || root == p || root == q) return root;

//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right, p,q);

//        if(left !=null && right != null) return root;
//        return (left !=null) ? left:right;

//     }
// }


class Solution{


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        if(root == p || root == q) return root;

        boolean pInLeft = exists(root.left, p);
        boolean qInLeft = exists(root.left, q);

        if( pInLeft != qInLeft ) return root;

        return pInLeft ? lowestCommonAncestor(root.left, p,q):
                        lowestCommonAncestor(root.right,p,q);

    }

    private boolean exists(TreeNode node, TreeNode target){
        if(node == null) return false;
        if(node == target ) return true;

        return exists(node.left, target ) || exists(node.right, target);
    }
}