// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 1){
            return true;
        }

        int inversions = 0;
        for (int i = 1; i < n; i++){
            if (nums[i-1] > nums[i]){
                inversions++;
            }
        }

        if (nums[n-1] > nums[0]){
            inversions++;
        }
        return inversions <= 1;
    }
}
