class Node {
    int sum;
    int L;
    int R;
    Node left;
    Node right;

    public Node(int sum, int L, int R){
        this.sum = sum;
        this.L = L;
        this.R = R;
        this.left = null;
        this.right = null;
    }
}

class NumArray {
    Node root;

    public NumArray(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    public Node build(int[] nums, int L, int R){
        if (L == R){
            return new Node(nums[L], L, R);
        }

        int M = (L + R) / 2;
        Node root = new Node(0, L, R);
        root.left = build(nums, L, M);
        root.right = build(nums, M+1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public void updateHelper(Node root, int index, int val){
        if (root.L == root.R){
            root.sum = val;
            return;
        }

        int m = (root.L + root.R) / 2;
        if (index > m){
            updateHelper(root.right, index, val);
        }
        else{
            updateHelper(root.left, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }

    public int sumRangeHelper(Node root, int L, int R){
        if (root.L == L && root.R == R){
            return root.sum;
        }

        int m = (root.L + root.R) / 2;
        if (m < L){
            return sumRangeHelper(root.right, L, R);
        }
        else if (R <= m){
            return sumRangeHelper(root.left, L, R);
        }
        else{
            return (sumRangeHelper(root.left, L, m) + sumRangeHelper(root.right, m+1, R));
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
