class Solution {
    public long subsequenceSumOr(int[] nums) {
        long ans = 0, prefix = 0;
        for (int n : nums){
            prefix += n;
            ans |= n | prefix;
        }
        return ans;
    }
}
