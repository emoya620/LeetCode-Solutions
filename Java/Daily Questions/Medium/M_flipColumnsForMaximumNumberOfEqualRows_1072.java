class Solution {
    // Time Complexity: O(n * m) | Space Complexity: O(n * m)
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> patternFreq = new HashMap<>();

        int maxPattern = 0;
        for (int[] row : matrix){
            StringBuilder pattern = new StringBuilder();
            
            for (int c = 0; c < row.length; c++){
                if (row[0] == row[c]){
                    pattern.append("T");
                }
                else{
                    pattern.append("F");
                }
            }

            String curPattern = pattern.toString();
            patternFreq.put(curPattern, patternFreq.getOrDefault(curPattern, 0) + 1);
            maxPattern = Math.max(maxPattern, patternFreq.get(curPattern));
        }
        return maxPattern;
    }
}
