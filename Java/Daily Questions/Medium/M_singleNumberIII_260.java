class Solution {
    public int[] singleNumber(int[] nums) {
        int xor2no = 0;
        for (int n : nums){
            xor2no ^= n;
        }

        int lowestBit = xor2no & (-xor2no);

        int[] ans = new int[2];
        for (int n : nums){
            if ((lowestBit & n) == 0){
                ans[0] ^= n;
            }
            else{
                ans[1] ^= n;
            }
        }
        return ans;
    }
}
