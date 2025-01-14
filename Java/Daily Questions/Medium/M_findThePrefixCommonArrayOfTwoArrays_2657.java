class Solution {
    // Time Complexity: O(n^2) | Space Complexity: O(n)
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] countA = new int[n];
        int[] countB = new int[n];

        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            countA[A[i] - 1]++;
            countB[B[i] - 1]++;

            int count = 0;
            for (int j = 0; j < n; j++){
                if (countA[j] == 1 && countB[j] == 1){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
