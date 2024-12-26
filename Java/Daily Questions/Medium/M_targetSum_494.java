class Solution {
    // Time Complexity: O(N * totalSum) | Space Complexity: O(2 * totalSum)
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();
        int[] dp = new int[2 * totalSum + 1];

        dp[nums[0] + totalSum] = 1;
        dp[-nums[0] + totalSum] += 1;

        for (int i = 1; i < nums.length; i++){
            int[] next = new int[2 * totalSum + 1];
            for (int sum = -totalSum; sum <= totalSum; sum++){
                if (dp[sum + totalSum] > 0){
                    next[sum + nums[i] + totalSum] += dp[sum + totalSum];
                    next[sum - nums[i] + totalSum] += dp[sum + totalSum];
                }
            }
            dp = next;
        }
        return Math.abs(target) > totalSum ? 0 : dp[target + totalSum];
    }
}
