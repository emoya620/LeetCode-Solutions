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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);

        if (root.val == target && root.left == null && root.right == null){
            return null;
        }

        return root;
    }

    public void dfs(TreeNode root, int target){
        if (root == null){
            return;
        }

        dfs(root.left, target);
        dfs(root.right, target);

        if (root.left != null && root.left.left == null && root.left.right == null && root.left.val == target){
            root.left = null;
        }
        if (root.right != null && root.right.left == null && root.right.right == null && root.right.val == target){
            root.right = null;
        }
    }
}
