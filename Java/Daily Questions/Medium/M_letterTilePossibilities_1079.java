// Time Complexity: O(n * n!) | Space Complexity: O(n * n!)
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> sequences = new HashSet<>();
        int len = tiles.length();
        boolean used[] = new boolean[len];

        generateSequences(tiles, "", used, sequences);
        
        return sequences.size() - 1;
    }

    public void generateSequences(String tiles, String curStr, boolean[] used, Set<String> sequences){
        sequences.add(curStr);

        for (int i = 0; i < tiles.length(); i++){
            if (!used[i]){
                used[i] = true;
                generateSequences(tiles, curStr + tiles.charAt(i), used, sequences);
                used[i] = false;
            }
        }
    }
}
