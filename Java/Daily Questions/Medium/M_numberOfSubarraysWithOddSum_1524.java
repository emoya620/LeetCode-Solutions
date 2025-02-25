// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int count = 0;
        int prefixSum = 0, oddCount = 0, evenCount = 1;

        for (int n : arr){
            prefixSum += n;
            if (prefixSum % 2 == 0){
                count += oddCount;
                evenCount++;
            }
            else{
                count += evenCount;
                oddCount++;
            }
            count %= MOD;
        }
        return count;
    }
}
