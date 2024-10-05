class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        for (char c : s1.toCharArray()){
            map1[c - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length() + 1; i++){
            int[] curMap = new int[26];
            for (char c : s2.substring(i,i+s1.length()).toCharArray()){
                curMap[c - 'a']++;
            }

            for (int x = 0; x < map1.length; x++){
                if (map1[x] != curMap[x]){
                    break;
                }

                if (x == 25){
                    return true;
                }
            }
        }
        return false;
    }
}
