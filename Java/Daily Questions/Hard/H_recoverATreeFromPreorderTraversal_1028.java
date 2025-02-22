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

// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        List<TreeNode> levels = new ArrayList<>();
        int index = 0, n = traversal.length();

        while (index < n){
            int depth = 0;
            while (index < n && traversal.charAt(index) == '-'){
                depth++;
                index++;
            }

            int value = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))){
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            if (depth < levels.size()){
                levels.set(depth, node);
            }
            else{
                levels.add(node);
            }

            if (depth > 0){
                TreeNode parent = levels.get(depth - 1);
                if (parent.left == null){
                    parent.left = node;
                }
                else{
                    parent.right = node;
                }
            }
        }
        return levels.get(0);
    }
}
