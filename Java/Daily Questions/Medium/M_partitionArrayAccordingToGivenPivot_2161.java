// Time Complexity: O(N) | Space Complexity: (1)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int numLesser = 0;
        int numEqual = 0;
        int numGreater = 0;
        for (int n : nums){
            if (n < pivot){
                numLesser++;
            }
            else if (n > pivot){
                numGreater++;
            }
            else{
                numEqual++;
            }
        }

        int lesserIndex = 0;
        int equalIndex = numLesser;
        int greaterIndex = numLesser + numEqual;
        int[] ans = new int[nums.length];
        for (int n : nums){
            if (n < pivot){
                ans[lesserIndex] = n;
                lesserIndex++;
            }
            else if (n > pivot){
                ans[greaterIndex] = n;
                greaterIndex++;
            }
            else{
                ans[equalIndex] = n;
                equalIndex++;
            }
        }

        return ans;
    }
}
