class TreeNode {
    int sum;
    int l;
    int r;
    TreeNode left;
    TreeNode right;

    public TreeNode(int total, int l, int r){
        this.sum = total;
        this.l = l;
        this.r = r;
        this.left = null;
        this.right = null;
    }
}

class SegmentTree {
    TreeNode root;

    public SegmentTree(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int r){
        if (l == r){
            return new TreeNode(nums[l], l, r);
        }

        int m = (l+r) / 2;
        TreeNode root = new TreeNode(0, l, r);
        root.left = build(nums, l, m);
        root.right = build(nums, m+1, r);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public void updateHelper(TreeNode root, int index, int val){
        if (root.l == root.r){
            root.sum = val;
            return;
        }

        int m = (root.l + root.r) / 2;
        if (index > m){
            updateHelper(root.right, index, val);
        }
        else{
            updateHelper(root.left, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int L, int R) {
        return queryHelper(root, L, R);
    }

    public int queryHelper(TreeNode root, int L, int R){
        if (L <= root.l && root.r <= R){
            return root.sum;
        }
        if (R < root.l || L > root.r){
            return 0;
        }
        return queryHelper(root.left, L, R) + queryHelper(root.right, L, R);
    }
}
