class Solution {
    // Time Complexity: O(n + maxValue) | Space Complexity: O(maxValue)
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1){
            return 1;
        }

        int maxBeauty = 0, maxValue = 0;
        for (int n : nums) maxValue = Math.max(maxValue, n);

        int[] count = new int[maxValue + 1];

        for (int n : nums){
            count[Math.max(n - k, 0)]++;
            count[Math.min(n + k + 1, maxValue)]--;
        }

        int curSum = 0;
        for (int val : count){
            curSum += val;
            maxBeauty = Math.max(maxBeauty, curSum);
        }
        return maxBeauty;
    }
}
