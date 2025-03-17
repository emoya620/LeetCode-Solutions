// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean divideArray(int[] nums) {
        int[] counts = new int[501];
        for (int n : nums){
            counts[n]++;
        }

        for (int count : counts){
            if (count % 2 == 1){
                return false;
            }
        }
        return true;
    }
}
