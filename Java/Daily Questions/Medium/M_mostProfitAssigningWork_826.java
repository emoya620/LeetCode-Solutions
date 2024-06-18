class Solution {    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m =  worker.length;

        int maxProfit = 0;
        for (int i = 0; i < m; i++){
            int curWorker = worker[i];
            int curProfit = 0;
            for (int j = 0; j < n; j++){
                if (difficulty[j] <= curWorker){
                    curProfit = Math.max(curProfit, profit[j]);
                }
            }
            maxProfit += curProfit;
        }
        return maxProfit;
    }
}
