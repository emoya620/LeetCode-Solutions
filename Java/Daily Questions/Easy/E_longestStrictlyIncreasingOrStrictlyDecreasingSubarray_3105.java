// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int left = 0;
        int right = 1;

        while (right < nums.length){
            if (nums[right - 1] >= nums[right]){
                left = right;
            }
            else if (right - left + 1 > maxLen){
                maxLen = right - left + 1;
            }
            right++;
        }

        left = 0;
        right = 1;
        while (right < nums.length){
            if (nums[right - 1] <= nums[right]){
                left = right;
            }
            else if (right - left + 1 > maxLen){
                maxLen = right - left + 1;
            }
            right++;
        }

        return maxLen;
    }
}
