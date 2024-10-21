class Solution {
    // Time Complexity: O(n * 2^n) | Space Complexity: O(n)
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return helper(set, s, 0);
    }

    public int helper(HashSet<String> curSet, String s, int index){
        if (index == s.length()){
            return 0;
        }

        int maxCount = 0;
        for (int j = index + 1; j <= s.length(); j++){
            String subStr = s.substring(index, j);
            if (!curSet.contains(subStr)){
                curSet.add(subStr);
                maxCount = Math.max(maxCount, 1 + helper(curSet, s, j));
                curSet.remove(subStr);
            }
        }
        return maxCount;
    }
}
