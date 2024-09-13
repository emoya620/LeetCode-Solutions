class Solution {
    // Initial Solution
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

    // Optimal Solution
    // Time Complexity: O(n) | Space Complexity: O(n + m)
    public int[] xorQueries2(int[] arr, int[][] queries) {
        int[] prefixArr = new int[arr.length];
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            prefixArr[i] = prefixArr[i-1] ^ arr[i];
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];

            if (left == 0){
                answer[i] = prefixArr[right];
            }
            else{
                answer[i] = prefixArr[right] ^ prefixArr[left-1];
            }
        }
        return answer;
    }
}
