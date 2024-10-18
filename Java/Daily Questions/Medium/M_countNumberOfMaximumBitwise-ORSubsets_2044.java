class Solution {
    // Time Complexity: O(2^n) | Space Complexity: O(n)
    int numMaxBitwiseOR = 0;
    public int countMaxOrSubsets(int[] nums) {
        int maxBitwiseOR = 0;
        for (int n : nums){
            maxBitwiseOR |= n;
        }

        helper(nums, 0, maxBitwiseOR, 0);
        return numMaxBitwiseOR;
    }

    public void helper(int[] nums, int index, int maxBitwiseOR, int curBitwiseOR){
        if (index == nums.length){
            numMaxBitwiseOR += (curBitwiseOR == maxBitwiseOR) ? 1 : 0;
            return;
        }

        helper(nums, index + 1, maxBitwiseOR, curBitwiseOR | nums[index]);
        helper(nums, index + 1, maxBitwiseOR, curBitwiseOR);
    }
}
