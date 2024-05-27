class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long totalHappiness = 0;
        int n = happiness.length, j = 0;
        for (int i = n - 1; i >= n - k; i--){
            happiness[i] = Math.max(0, happiness[i] - j);
            j++;
            totalHappiness += happiness[i];
        }
        return totalHappiness;
    }
}
