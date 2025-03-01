// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        int updatePos = 0;

        for (int i = 0; i < nums.length; i++){
            if (i + 1 != nums.length){
                if (nums[i] == 0){
                    continue;
                }
                
                if (nums[i] == nums[i+1]){
                    nums[i] *= 2;
                    nums[i+1] = 0;
                }

                if (i != updatePos){
                    nums[updatePos] = nums[i];
                    nums[i] = 0;
                }
                
                updatePos++;
            }
            else{
                if (nums[i] != 0 && nums[updatePos] == 0){
                    nums[updatePos] = nums[i];
                    nums[i] = 0;
                }
            }
        }
        return nums;
    }
}
