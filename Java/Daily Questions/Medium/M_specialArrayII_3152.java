class Solution {
    // Time Complexity: O(M + N) | Space Complexity: O(M)
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        
        int numSame = 0;
        prefix[0] = numSame;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] % 2 == nums[i] % 2){
                numSame++;
            }
            prefix[i] = numSame;
        }

        boolean[] answer = new boolean[queries.length];
        int i = 0;
        for (int[] query : queries){
            int start = query[0];
            int end = query[1];
            answer[i] = prefix[start] == prefix[end];
            i++;
        }
        return answer;
    }
}
