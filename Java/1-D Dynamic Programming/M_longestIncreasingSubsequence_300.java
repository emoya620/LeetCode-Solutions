class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        for (int n : nums){
            int i = 0, j = size;
            while (i != j){
                int m = (i+j) / 2;
                if (dp[m] < n){
                    i = m + 1;
                }
                else{
                    j = m;
                }
            }
            dp[i] = n;

            if (i == size){
                size++;
            }
        }
        return size;
    }
}
