class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int n : nums){
            ans = ans ^ n;
        }
        ans = ans ^ k;

        int result = 0;
        while (ans > 0){
            if ((ans & 1) != 0){
                result++;
            }
            ans = ans >> 1;
        }
        return result;
    }
}
