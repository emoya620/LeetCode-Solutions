// Time Complexity: O(n + k) | Space Complexity: O(1)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int length = colors.length;
        int result = 0;
        int alternatingElementsCount = 1;
        int lastColor = colors[0];

        for (int i = 1; i < length + k- 1; i++){
            int index = i % length;

            if (colors[index] == lastColor){
                alternatingElementsCount = 1;
                lastColor = colors[index];
                continue;
            }

            alternatingElementsCount++;

            if (alternatingElementsCount >= k){
                result++;
            }
            lastColor = colors[index];
        }
        return result;
    }
}
