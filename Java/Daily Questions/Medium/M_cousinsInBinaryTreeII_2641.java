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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<Pair<TreeNode,TreeNode>> queue = new LinkedList();
        if (root == null) return null;

        root.val = 0;
        Pair<TreeNode, TreeNode> pair = new Pair<>(root.left, root.right);
        queue.offer(pair);
        while (!queue.isEmpty()){
            ArrayList<Pair<TreeNode, TreeNode>> pairList = new ArrayList<>();
            int levelSum = 0;
            int length = queue.size();
            for (int i = 0; i < length; i++){
                Pair<TreeNode, TreeNode> curPair = queue.remove();
                pairList.add(curPair);
                TreeNode left = curPair.getKey();
                TreeNode right = curPair.getValue();
                
                if (left != null){
                    levelSum += left.val;
                    Pair<TreeNode, TreeNode> leftPair = new Pair<>(left.left, left.right);
                    queue.offer(leftPair);
                }
                if (right != null){
                    levelSum += right.val;
                    Pair<TreeNode, TreeNode> rightPair = new Pair<>(right.left, right.right);
                    queue.offer(rightPair);
                }
            }

            int pairSum;
            for (Pair<TreeNode, TreeNode> p : pairList){
                pairSum = 0; 
                TreeNode l = p.getKey();
                TreeNode r = p.getValue();
                pairSum += l == null ? 0 : l.val;
                pairSum += r == null ? 0 : r.val;
                
                if (l != null){
                    l.val = levelSum - pairSum;
                }
                if (r != null){
                    r.val = levelSum - pairSum;
                }
            }
        }
        return root;
    }
}
