class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(items, (a,b) -> a[0] - b[0]);

        int[][] queriesWithIndices = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++){
            queriesWithIndices[i][0] = queries[i];
            queriesWithIndices[i][1] = i;
        }
        Arrays.sort(queriesWithIndices, (a,b) -> a[0] - b[0]);

        int maxVal = 0;
        int index = 0;
        for (int[] query : queriesWithIndices){
            while (index < items.length && items[index][0] <= query[0]){
                maxVal = Math.max(maxVal, items[index][1]);
                index++;
            }
            ans[query[1]] = maxVal;
        }
        return ans;
    }
}
