// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = 0, maxPrefixSum = 0;
        int prefixSum = 0;

        for (int n : nums){
            prefixSum += n;

            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }
        return maxPrefixSum - minPrefixSum;
    }
}
