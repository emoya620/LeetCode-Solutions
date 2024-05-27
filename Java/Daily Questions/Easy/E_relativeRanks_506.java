class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<Integer> arr = new ArrayList<>();
        for (int n : score){
            arr.add(n);
        }

        Arrays.sort(score);
        String[] ans = new String[score.length];
        int placement = 4;
        for (int i = score.length - 1; i >= 0; i--){
            int index = arr.indexOf(score[i]);

            if (i == score.length - 1){
                ans[index] = "Gold Medal";
            }
            else if (i == score.length - 2){
                ans[index] = "Silver Medal";
            }
            else if (i == score.length - 3){
                ans[index] = "Bronze Medal";
            }
            else{
                ans[index] = Integer.toString(placement);
                placement++;
            }
        }

        return ans;
    }
}
