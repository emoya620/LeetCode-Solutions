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
    // Time Complexity: O(N) | Space Complexity: O(N)
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null){
            return ans;
        }

        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++){
                TreeNode curNode = queue.poll();
                maxVal = Math.max(maxVal, curNode.val);
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            ans.add(maxVal);
        }
        return ans;
    }
}
