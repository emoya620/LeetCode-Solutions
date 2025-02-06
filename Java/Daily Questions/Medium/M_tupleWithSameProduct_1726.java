// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pairProductsFrequency = new HashMap<>();
        int totalNumberOfTuples = 0;

        for (int firstIndex = 0; firstIndex < n; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < n; secondIndex++) {
                pairProductsFrequency.put(nums[firstIndex] * nums[secondIndex],
                    pairProductsFrequency.getOrDefault(nums[firstIndex] * nums[secondIndex], 0) + 1);
            }
        }

        for (int productValue : pairProductsFrequency.keySet()) {
            int productFrequency = pairProductsFrequency.get(productValue);
            int pairsOfEqualProduct = ((productFrequency - 1) * productFrequency) / 2;
            totalNumberOfTuples += 8 * pairsOfEqualProduct;
        }

        return totalNumberOfTuples;
    }
}
