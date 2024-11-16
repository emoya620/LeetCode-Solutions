class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1){
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1);
        int consecutiveCount = 1;

        for (int i = 0; i < length - 1; i++){
            if (nums[i] + 1 == nums[i+1]){
                consecutiveCount++;
            }
            else{
                consecutiveCount = 1;
            }

            if (consecutiveCount >= k){
                result[i - k + 2] = nums[i + 1];
            }
        }
        return result;
    }
}
