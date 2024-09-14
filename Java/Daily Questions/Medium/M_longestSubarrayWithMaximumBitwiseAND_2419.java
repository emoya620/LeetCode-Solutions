class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int longestSubarray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int n : nums){
            maxVal = Math.max(maxVal, n);
        }

        int length = 1;
        int tempLength = 0;
        for (int n : nums){
            if (n == maxVal){
                tempLength++;
            }
            else {
                length = Math.max(length, tempLength);
                tempLength = 0;
            }
        }
        return Math.max(tempLength, length);
    }

    // Brute-Force: Time Complexity: O(n^2) | Space Complexity: O(1)
    public int longestSubarray2(int[] nums) {
        int maxVal = 0;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++){
            int curVal = nums[i];
            for (int j = i; j < nums.length; j++){
                curVal &= nums[j];
                if (curVal > maxVal){
                    maxVal = curVal;
                    maxLength = j-i + 1;
                }
                else if (curVal == maxVal){
                    maxLength = Math.max(j-i + 1, maxLength);
                }
            }
        }
        return maxLength;
    }
}
