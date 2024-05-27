class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        int totalSum = 0;
        while (right < nums.length){
            totalSum += nums[right];

            while (totalSum >= target){
                minLength = Math.min(minLength, right - left + 1);
                totalSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
