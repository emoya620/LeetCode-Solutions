class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int n : nums){
            totalSum += n;
        }

        int ans = 0;
        long curSum = 0;
        for (int i = 0; i < nums.length - 1; i++){
            curSum += nums[i];
            if (totalSum - curSum <= curSum){
                ans++;
            }
        }
        return ans;
    }
}
