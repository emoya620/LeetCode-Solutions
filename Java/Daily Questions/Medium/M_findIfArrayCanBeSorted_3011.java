class Solution {
    // Time Complexity: O(N^2 * log(N)) | Space Complexity: O(N)
    public boolean canSortArray(int[] nums) {
        int left = 0;
        int curMinVal;
        int curMinIndex;

        while (left< nums.length){
            curMinVal = Integer.MAX_VALUE;
            curMinIndex = -1;
            for (int i = left; i < nums.length; i++){
                if (curMinVal > nums[i]){
                    curMinVal = nums[i];
                    curMinIndex = i;
                }
            }

            while (curMinIndex > left){
                if (!canSwap(nums[curMinIndex], nums[curMinIndex - 1])){
                    return false;
                }
                int temp = nums[curMinIndex-1];
                nums[curMinIndex-1] = nums[curMinIndex];
                nums[curMinIndex] = temp;
                curMinIndex--;
            }

            left++;
        }
        return true;
    }

    public boolean canSwap(int num1, int num2){
        int count1 = 0;
        int count2 = 0;

        while (num1 > 0){
            count1 += (num1 & 1);
            num1 >>= 1;
        }

        while (num2 > 0){
            count2 += (num2 & 1);
            num2 >>= 1;
        }
        return count1 == count2;
    }
}
