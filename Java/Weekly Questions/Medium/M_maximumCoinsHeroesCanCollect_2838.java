class Solution {
    // Time Complexity: O(n * log m) | Space Complexity: O(m + log n)
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        long[] ans = new long[heroes.length];
        int[][] monsterAndCoin = new int[monsters.length][2];
        for (int i = 0; i < monsters.length; i++){
            monsterAndCoin[i][0] = monsters[i];
            monsterAndCoin[i][1] = coins[i];
        }

        Arrays.sort(monsterAndCoin, (a, b) -> a[0] - b[0]);
        long[] coinSum = new long[coins.length];
        long prefixSum = 0;
        for (int i = 0; i < monsterAndCoin.length; i++){
            prefixSum += monsterAndCoin[i][1];
            coinSum[i] = prefixSum;
        }

        for (int i = 0; i < heroes.length; i++){
            ans[i] = binarySearch(monsterAndCoin, heroes[i], coinSum);
        }
        return ans;
    }

    public long binarySearch(int[][] monsterAndCoin, int heroPower, long[] coinSum){
        int left = 0;
        int right = monsterAndCoin.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (monsterAndCoin[middle][0] > heroPower){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        
        if (left == 0 && monsterAndCoin[left][0] > heroPower){
            return 0;
        }
        return coinSum[right];
    }
}
