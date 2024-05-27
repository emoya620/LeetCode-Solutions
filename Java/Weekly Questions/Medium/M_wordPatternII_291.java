class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>();
        return isMatch(s, 0, pattern, 0, map, wordSet);
    }

    public boolean isMatch(String str, int i, String pattern, int j, HashMap<Character, String> map, HashSet<String> wordSet){
        // Base Cases
        if (i == str.length() && j == pattern.length()){
            return true;
        }
        if (i == str.length() || j == pattern.length()){
            return false;
        }

        // Get current pattern character
        char c = pattern.charAt(j);

        // If the character exists in the map
        if (map.containsKey(c)){
            String s = map.get(c);

            // Check to see if we can use it to match str.substring(i...i + s.length())
            if (!str.startsWith(s, i)){
                return false;
            }

            // If matched, then continue to search through the string
            return isMatch(str, i + s.length(), pattern, j + 1, map, wordSet);
        }

        // When pattern character does not exist in the map
        for (int k = i; k < str.length(); k++){
            String p = str.substring(i, k+1);

            // If the pattern is already mapped to another character, then skip this pattern
            if (wordSet.contains(p)){
                continue;
            }

            // Create or update the map
            map.put(c, p);
            wordSet.add(p);

            // Continue matching the rest of the string
            if (isMatch(str, k+1, pattern, j+1, map, wordSet)){
                return true;
            }

            // Backtracking
            map.remove(c);
            wordSet.remove(p);
        }

        // The string cannot be matched to the pattern
        return false;
    }
}
