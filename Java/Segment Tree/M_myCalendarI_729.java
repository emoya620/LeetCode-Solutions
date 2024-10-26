class TreeNode {
    int start;
    int end;
    TreeNode left;
    TreeNode right;

    public TreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
    }
}

class MyCalendar {
    TreeNode root;

    public MyCalendar() {
        this.root = null;
    }
    
    public boolean book(int start, int end) {
        if (this.root == null){
            this.root = new TreeNode(start, end);
            return true;
        }
        return update(this.root, start, end);
    }

    public boolean update(TreeNode node, int start, int end){
        if (end <= node.start){
            if (node.left == null){
                node.left = new TreeNode(start, end);
                return true;
            }
            return update(node.left, start, end);
        }
        if (start >= node.end){
            if (node.right == null){
                node.right = new TreeNode(start, end);
                return true;
            }
            return update(node.right, start, end);
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
