class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLen = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        int[] bitCounts = new int[32];

        while (windowEnd < nums.length){
            updateBitCounts(bitCounts, nums[windowEnd], 1);

            while (windowStart <= windowEnd && convertBitCountsToNumber(bitCounts) >= k){
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                updateBitCounts(bitCounts, nums[windowStart], -1);
                windowStart++;
            }
            windowEnd++;
        }
        return minLen == Integer.MAX_VALUE  ? -1: minLen;
    }

    private void updateBitCounts(int[] bitCounts, int number, int delta){
        for (int bitPosition = 0; bitPosition < 32; bitPosition++){
            if (((number >> bitPosition) & 1) != 0){
                bitCounts[bitPosition] += delta;
            }
        }
    }

    private int convertBitCountsToNumber(int[] bitCounts){
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++){
            if (bitCounts[bitPosition] != 0){
                result |= 1 << bitPosition;
            }
        }
        return result;
    }
}
