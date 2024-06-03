class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> longestSubsequence = new ArrayList<>();
        int minLen = arrays[0].length;
        for (int[] arr : arrays){
            if (arr.length <= minLen){
                longestSubsequence = new ArrayList<>();
                for (int n : arr){
                    longestSubsequence.add(n);
                }
                minLen = arr.length;
            }
        }

        for (int[] arr : arrays){
            int i = 0;
            int j = 0;
            while (j < arr.length && i < longestSubsequence.size()){
                if (arr[j] == longestSubsequence.get(i)){
                    i++;
                    j++;
                }
                else if (arr[j] > longestSubsequence.get(i)){
                    longestSubsequence.remove(i);
                }
                else{
                    j++;
                }
            }
            longestSubsequence.subList(i, longestSubsequence.size()).clear();
        }
        return longestSubsequence;
    }
}
