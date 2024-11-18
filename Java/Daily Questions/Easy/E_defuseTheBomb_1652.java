class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0){
            return new int[n];
        }

        int[] prefixArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += code[i];
            prefixArr[i] = sum;
        }

        int[] decoded = new int[n];
        for (int i = 0; i < n; i++){
            if (k > 0){
                if (i + k < n){
                    decoded[i] = prefixArr[i+k] - prefixArr[i];
                }
                else{
                    int loopIndex = (i+k) - n;
                    decoded[i] = prefixArr[loopIndex] + (prefixArr[n-1] - prefixArr[i]);
                }
            }
            else{
                if (i + k >= 0){
                    decoded[i] = (i+k) != 0 ? prefixArr[i-1] - prefixArr[i+k-1] : prefixArr[i-1];
                }
                else{
                    int loopIndex = (i+k) + n;
                    decoded[i] = i != 0 ? prefixArr[i-1] + (prefixArr[n-1] - prefixArr[loopIndex-1]) : prefixArr[n-1] - prefixArr[loopIndex-1];
                }
            }
        }
        return decoded;
    }
}
