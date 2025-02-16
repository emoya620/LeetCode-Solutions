// Time Complexity: O(n!) | Space Complexity: O(n)
class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[(2 * n) - 1];
        boolean[] isNumberUsed = new boolean[n+1];
        backtracking(0, ans, isNumberUsed, n);
        return ans;
    }

    public boolean backtracking(int curIndex, int[] curArr, boolean[] isNumberUsed, int n){
        if (curIndex == curArr.length){
            return true;
        }
        if (curArr[curIndex] != 0){
            return backtracking(curIndex+1, curArr, isNumberUsed, n);
        }

        for (int numToPlace = n; numToPlace >= 1; numToPlace--){
            if (isNumberUsed[numToPlace] == true){
                continue;
            }
            
            isNumberUsed[numToPlace] = true;
            curArr[curIndex] = numToPlace;

            if (numToPlace == 1){
                if (backtracking(curIndex+1, curArr, isNumberUsed, n)){
                    return true;
                }
            }
            else if (curIndex + numToPlace < curArr.length && curArr[curIndex + numToPlace] == 0){
                curArr[curIndex + numToPlace] = numToPlace;
                if (backtracking(curIndex+1, curArr, isNumberUsed, n)){
                    return true;
                }
                curArr[curIndex + numToPlace] = 0;
            }

            curArr[curIndex] = 0;
            isNumberUsed[numToPlace] = false;
        }
        return false;
    }
}
