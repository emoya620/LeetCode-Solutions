class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int maximumSwap(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int n = charArr.length;
        int maxDigitIndex = -1, swapIdx1 = -1, swapIdx2 = -1;

        for (int i = n - 1; i >= 0; i--){
            if (maxDigitIndex == -1 || charArr[i] > charArr[maxDigitIndex]){
                maxDigitIndex = i;
            }
            else if (charArr[i] < charArr[maxDigitIndex]){
                swapIdx1 = i;
                swapIdx2 = maxDigitIndex;
            }
        }

        if (swapIdx1 != -1 && swapIdx2 != -1){
            char temp = charArr[swapIdx1];
            charArr[swapIdx1] = charArr[swapIdx2];
            charArr[swapIdx2] = temp;
        }
        return Integer.parseInt(new String(charArr));
    }
}
