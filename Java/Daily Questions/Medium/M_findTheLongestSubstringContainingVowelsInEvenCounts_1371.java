class Solution {
    public int findTheLongestSubstring(String s) {
        int[] map = new int[32];
        Arrays.fill(map, -2);
        map[0] = -1;

        int maxLen = 0;
        int mask = 0;
        for (int i = 0; i < s.length(); i++){
            char curChar = s.charAt(i);

            switch (curChar){
                case 'a':
                    mask ^= 1;
                    break;
                case 'e':
                    mask ^= 2;
                    break;
                case 'i':
                    mask ^= 4;
                    break;
                case 'o':
                    mask ^= 8;
                    break;
                case 'u':
                    mask ^= 16;
                    break;
            }

            int prev = map[mask];
            if (prev == -2){
                map[mask] = i;
            }
            else{
                maxLen = Math.max(maxLen, i - prev);
            }
        }
        return maxLen;
    }
}
