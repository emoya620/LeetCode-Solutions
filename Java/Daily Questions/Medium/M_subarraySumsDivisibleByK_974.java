class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum %= k;

            if (sum < 0){
                sum += k;
            }

            if (prefixSums.containsKey(sum)){
                ans += prefixSums.get(sum);
                prefixSums.put(sum, prefixSums.get(sum) + 1);
            }
            else{
                prefixSums.put(sum, 1);
            }
        }
        return ans;
    }
}
