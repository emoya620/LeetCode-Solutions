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
    // Time Complexity: O(n + q) | Space Complexity: O(n)
    static final int[] maxHeightAfterRemoval = new int[100001];
    int currentMaxHeight = 0;

    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0;
        traverseRightToLeft(root, 0);

        // Process queries and build the result array
        int queryCount = queries.length;
        int[] result = new int[queryCount];
        for (int i = 0; i < queryCount; i++){
            result[i] = maxHeightAfterRemoval[queries[i]];
        }
        return result;
    }

    private void traverseLeftToRight(TreeNode node, int currentHeight){
        if (node == null){
            return;
        }
        
        maxHeightAfterRemoval[node.val] = currentMaxHeight;
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode node, int currentHeight){
        if (node == null){
            return;
        }

        maxHeightAfterRemoval[node.val] = Math.max(maxHeightAfterRemoval[node.val], currentMaxHeight);
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }
}
