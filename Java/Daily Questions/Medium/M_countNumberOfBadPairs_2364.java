// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long badPairs= 0;
        for (int i = 0; i < nums.length; i++){
           int diff = nums[i] - i;
           int goodPairs = map.getOrDefault(diff, 0);
           
           badPairs += i - goodPairs;
           map.put(diff, goodPairs + 1);
        }

        return badPairs;
    }
}
