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

// Time Complexity: O(n) | Space Complexity: O(1)
class FindElements {
    TreeNode recoveredTree;
    HashSet<Integer> uniqueElements = new HashSet<>();

    public FindElements(TreeNode root) {
        uniqueElements.add(0);

        root.val = 0;
        recover(root);
        this.recoveredTree = root;
    }
    
    public boolean find(int target) {
        return uniqueElements.contains(target);
    }

    public void recover(TreeNode root){
        if (root.left != null){
            root.left.val = root.val * 2 + 1;
            uniqueElements.add(root.left.val);
            recover(root.left);
        }
        if (root.right != null){
            root.right.val = root.val * 2 + 2;
            uniqueElements.add(root.right.val);
            recover(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
