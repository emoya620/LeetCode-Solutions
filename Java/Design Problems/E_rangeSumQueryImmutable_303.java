class NumArray {
    int[] prefixSums;

    public NumArray(int[] nums) {
        if (nums.length == 0){
            this.prefixSums = new int[]{};
            return;
        }

        this.prefixSums = new int[nums.length];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++){
            curSum += nums[i];
            this.prefixSums[i] = curSum;
        }
    }
    
    public int sumRange(int left, int right) {
        return left == 0 ? this.prefixSums[right] : this.prefixSums[right] - this.prefixSums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
