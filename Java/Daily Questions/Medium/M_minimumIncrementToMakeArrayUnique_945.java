class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int numTracker = 0;
        int moves = 0;

        for (int num : nums){
            numTracker = Math.max(numTracker, num);
            moves += numTracker - num;
            numTracker++;
        }
        return moves;
    }
}
