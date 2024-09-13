class Solution {
    // Time Complexity: O(n*m) | Space Complexity: O(n)
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];

            int val = arr[left];
            for (int j = left+1; j <= right; j++){
                val ^= arr[j];
            }
            answer[i] = val;
        }
        return answer;
    }
}
