class Solution {
    public int longestRepeatingSubstring(String s) {
        HashMap<String, Integer> substrings = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j < s.length()+1; j++){
                String curSubstring = s.substring(i,j);
                if (substrings.containsKey(curSubstring)){
                    substrings.put(curSubstring, substrings.get(curSubstring) + 1);
                }
                else{
                    substrings.put(curSubstring, 1);
                }
            }
        }

        int longestSubstring = 0;
        for (Map.Entry<String, Integer> entry : substrings.entrySet()){
            if (entry.getValue() > 1){
                longestSubstring = Math.max(longestSubstring, entry.getKey().length());
            }
        }
        return longestSubstring;
    }
}
