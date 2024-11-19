class Solution {
    // Time Complexity: O(N) | Space Complexity: O(N)
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        long subarraySum = 0, maxSubarraySum = 0;
        int left = 0, right = 0;
        while (right < k){
            subarraySum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            right++;
        }

        if (freq.size() == k){
            maxSubarraySum = subarraySum;
        }

        while (right < nums.length){
            subarraySum -= nums[left];
            if (freq.get(nums[left]) - 1 == 0){
                freq.remove(nums[left]);
            }
            else{
                freq.put(nums[left], freq.get(nums[left]) - 1);
            }

            subarraySum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (freq.size() == k){
                maxSubarraySum = Math.max(maxSubarraySum, subarraySum);
            }
            left++;
            right++;
        }
        return maxSubarraySum;
    }
}
