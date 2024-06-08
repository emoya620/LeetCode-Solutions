class Solution {
    public long numberOfSubstrings(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        long sum = 0;
        for (char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
            sum += count.get(c);
        }
        return sum;
    }
}
