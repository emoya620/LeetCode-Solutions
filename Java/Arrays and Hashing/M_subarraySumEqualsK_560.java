class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;
        int curSum = 0;
        for (int n : nums){
            curSum += n;
            int diff = curSum - k;

            result += map.getOrDefault(diff, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return result;
    }
}
