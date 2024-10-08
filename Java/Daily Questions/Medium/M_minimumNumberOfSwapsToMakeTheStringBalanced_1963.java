class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '['){
                stackSize++;
            }
            else{
                if (stackSize > 0){
                    stackSize--;
                }
            }
        }
        return (stackSize + 1) / 2;
    }
}
