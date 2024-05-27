class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int badIndex = -1, left = -1, right = -1;

        for (int i = 0; i < nums.length; i++){
            if (!(minK <= nums[i] && nums[i] <= maxK)){
                badIndex = i;
            }

            if (nums[i] == minK){
                left = i;
            }

            if (nums[i] == maxK){
                right = i;
            }

            ans += Math.max(0, Math.min(left, right) - badIndex);
        }
        return ans;
    }
}
