class Solution {
    public int specialArray(int[] nums) {
        int[] numCounts = new int[nums.length+1];
        for (int n : nums){
            if (n >= nums.length){
                numCounts[nums.length]++;
            }
            else{
                numCounts[n]++;
            }
        }

        int numBigger = 0;
        for (int x = nums.length; x > 0; x--){
            numBigger += numCounts[x];
            if (x < numBigger){
                return -1;
            }
            else if (x == numBigger){
                return x;
            }
        }

        return -1;
    }
}
