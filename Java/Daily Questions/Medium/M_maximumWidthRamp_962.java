class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int maxWidthRamp(int[] nums) {
        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        while (right < nums.length){
            while (left < right && nums[left] > rightMax[right]){
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }
        return maxWidth;
    }
}
