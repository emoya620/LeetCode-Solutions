class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int kElements = subarrayWithAtMostK(nums, k);
        int reducedKElements = subarrayWithAtMostK(nums, k-1);
        return kElements - reducedKElements;
    }

    public int subarrayWithAtMostK(int[] nums, int k){
        HashMap<Integer, Integer> counts = new HashMap<>();

        int right = 0;
        int left = 0;
        int numSubarrays = 0;
        while (right < nums.length){
            if (counts.containsKey(nums[right])){
                counts.put(nums[right], counts.get(nums[right]) + 1);
            }
            else{
                counts.put(nums[right], 1);
            }

            while (counts.size() > k){
                if (counts.get(nums[left]) == 1){
                    counts.remove(nums[left]);
                }
                else{
                    counts.put(nums[left], counts.get(nums[left]) - 1);
                }
                left++;
            }
            numSubarrays += right - left + 1;
            right++;
        }
        return numSubarrays;
    }
}
