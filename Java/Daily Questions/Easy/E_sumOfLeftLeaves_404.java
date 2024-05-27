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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int total = 0;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.remove();
            if (curNode.left != null && curNode.left.left == null && curNode.left.right == null){
                total += curNode.left.val;
            }
            if (curNode.left != null){
                queue.add(curNode.left);
            }
            if (curNode.right != null){
                queue.add(curNode.right);
            }
        }
        return total;
    }
}
