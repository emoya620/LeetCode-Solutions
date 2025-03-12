// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int maximumCount(int[] nums) {
        int numNegative = 0;
        int numPositive = 0;
        for (int n : nums){
            if (n < 0){
                numNegative++;
            }
            else if (n > 0){
                numPositive++;
            }
        }
        return Math.max(numNegative, numPositive);
    }
}
