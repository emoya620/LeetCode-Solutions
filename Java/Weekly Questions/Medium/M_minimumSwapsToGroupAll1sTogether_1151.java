// Time Complexity: O(N) | Space Complexity: O(1)
class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int countOne = 0, maxOne = 0;
        int left = 0, right = 0;

        while (right < data.length){
            countOne += data[right++];

            if (right - left > ones){
                countOne -= data[left++];
            }

            maxOne = Math.max(countOne, maxOne);
        }
        return ones - maxOne;
    }
}
