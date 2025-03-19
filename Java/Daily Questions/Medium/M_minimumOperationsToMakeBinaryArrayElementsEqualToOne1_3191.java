// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++){
            if (nums[i-2] == 0){
                count++;
                nums[i-2] = nums[i-2] ^ 1;
                nums[i-1] = nums[i-1] ^ 1;
                nums[i] = nums[i] ^ 1;
            }
        }

        int sum = 0;
        for (int n : nums){
            sum += n;
        }

        return sum == nums.length ? count : -1;
    }
}
