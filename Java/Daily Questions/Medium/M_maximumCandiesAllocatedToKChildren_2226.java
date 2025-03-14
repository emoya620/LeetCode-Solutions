// Time Complexity: O(n log(m)) | Space Complexity: O(1)
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandiesInPile = 0;
        for (int pile : candies){
            maxCandiesInPile = Math.max(maxCandiesInPile, pile);
        }

        int left = 0;
        int right = maxCandiesInPile;
        while (left < right){
            int middle = (left + right + 1) / 2;

            if (canAllocate(candies, k, middle)){
                left = middle;
            }
            else{
                right = middle - 1;
            }
        }
        return left;
    }

    public boolean canAllocate(int[] candies, long k, int middle){
        long maxChildren = 0;
        for (int pile : candies){
            maxChildren += pile / middle;
        }
        return maxChildren >= k;
    }
}
