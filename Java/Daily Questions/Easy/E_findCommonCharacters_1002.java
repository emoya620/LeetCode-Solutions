class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        Arrays.fill(freq, Integer.MAX_VALUE);

        for (String s : words){
            int[] curFreq = new int[26];
            for (Character c : s.toCharArray()){
                curFreq[c - 'a']++;
            }

            for (int i = 0; i < freq.length; i++){
                freq[i] = Math.min(curFreq[i], freq[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i]; j++){
                ans.add(Character.toString((char) i + 'a'));
            }
        }

        return ans;
    }
}
