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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        dfs(root, lonelyNodes);
        return lonelyNodes;
    }

    public void dfs(TreeNode root, List<Integer> lonelyNodes){
        if (root == null){
            return;
        }

        if (root.left == null && root.right != null){
            lonelyNodes.add(root.right.val);
        }

        if (root.left != null && root.right == null){
            lonelyNodes.add(root.left.val);
        }

        dfs(root.left, lonelyNodes);
        dfs(root.right, lonelyNodes);
    }
}
