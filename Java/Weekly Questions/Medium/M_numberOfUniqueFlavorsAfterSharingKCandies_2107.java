class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int shareCandies(int[] candies, int k) {
        int uniqueFlavor = 0;

        Map<Integer, Integer> flavorFreq = new HashMap<>();
        for (int c : candies){
            flavorFreq.put(c, flavorFreq.getOrDefault(c, 0) + 1);
            if (flavorFreq.get(c) == 1){
                uniqueFlavor++;
            }
        }

        int usedInWindow = 0;
        for (int i = 0; i < k; i++){
            flavorFreq.put(candies[i], flavorFreq.get(candies[i]) - 1);
            if (flavorFreq.get(candies[i]) == 0){
                usedInWindow++;
            }
        }

        int maxFlavor = uniqueFlavor - usedInWindow;
        for (int i = k; i < candies.length; i++){
            flavorFreq.put(candies[i-k], flavorFreq.get(candies[i-k]) + 1);
            if (flavorFreq.get(candies[i-k]) == 1){
                usedInWindow--;
            }

            flavorFreq.put(candies[i], flavorFreq.get(candies[i]) - 1);
            if (flavorFreq.get(candies[i]) == 0){
                usedInWindow++;
            }
            maxFlavor = Math.max(maxFlavor, uniqueFlavor - usedInWindow);
        }
        return maxFlavor;
    }
}
