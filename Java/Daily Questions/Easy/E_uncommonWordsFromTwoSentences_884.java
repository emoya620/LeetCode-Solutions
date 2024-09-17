class Solution {
    // Time Complexity: O(n + m) | Space Complexity: O(n + m)
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> stringCounts = new HashMap<>();

        // O(n)
        int left = 0;
        for (int right = 0; right < s1.length(); right++){
            while (right < s1.length() && Character.isAlphabetic(s1.charAt(right))){
                right++;
            }
            String str = s1.substring(left, right);
            left = right + 1;

            stringCounts.put(str, stringCounts.getOrDefault(str, 0) + 1);
        }

        // O(m)
        left = 0;
        for (int right = 0; right < s2.length(); right++){
            while (right < s2.length() && Character.isAlphabetic(s2.charAt(right))){
                right++;
            }
            String str = s2.substring(left, right);
            left = right + 1;

            stringCounts.put(str, stringCounts.getOrDefault(str, 0) + 1);
        }

        // O(n + m)
        ArrayList<String> strs = new ArrayList<>();
        for (String key : stringCounts.keySet()){
            if (stringCounts.get(key) == 1){
                strs.add(key);
            }
        }

        String[] ans = new String[strs.size()];
        strs.toArray(ans);
        return ans;
    }
}
