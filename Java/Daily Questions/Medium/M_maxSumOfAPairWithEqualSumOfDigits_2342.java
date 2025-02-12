// Time Complexity: O(n * log(m)) | Space Complexity: O(log(m))
class Solution {
    public int maximumSum(int[] nums) {
        int result = -1;
        int[] digitMapping = new int[82];

        for (int n : nums){
            int digitSum = 0;
            for (int curVal = n; curVal > 0; curVal /= 10){
                digitSum += curVal % 10;
            }

            if (digitMapping[digitSum] > 0){
                result = Math.max(result, digitMapping[digitSum] + n);
            }

            digitMapping[digitSum] = Math.max(digitMapping[digitSum], n);
        }
        return result;
    }
}
