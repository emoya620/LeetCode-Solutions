class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0){
            return false;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0){
                if (!findGroup(nums, k, i, n)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findGroup(int[] nums, int k, int i, int n){
        int nextVal = nums[i] + 1;
        nums[i] = -1;
        int count = 1;
        i++;
        while (i < n && count < k){
            if (nums[i] == nextVal){
                nextVal = nums[i] + 1;
                nums[i] = -1;
                count++;
            }
            i++;
        }

        if (count < k){
            return false;
        }
        return true;
    }
}
