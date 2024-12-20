class Solution {
    // Time Complexity: O(N) | Space Complexity: O(N)
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        for (int curIndex = 0; curIndex < n; curIndex++){
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[curIndex]){
                indexStack.pop();
            }
            left[curIndex] = indexStack.isEmpty() ? -1 : indexStack.peek();
            indexStack.push(curIndex);
        }
        indexStack.clear();

        for (int curIndex = n-1; curIndex >= 0; curIndex--){
            while(!indexStack.isEmpty() && nums[indexStack.peek()] < nums[curIndex]){
                indexStack.pop();
            }
            right[curIndex] = indexStack.isEmpty() ? n : indexStack.peek();
            indexStack.push(curIndex);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = right[i] - left[i] - 1;
        }
        return ans;
    }
}
