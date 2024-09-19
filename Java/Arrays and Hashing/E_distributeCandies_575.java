class Solution {
    // Time Complexity: O(n) | Space Complexity: O(n)
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> uniqueTypes = new HashSet<>();
        // O(n)
        for (int candy : candyType){
            uniqueTypes.add(candy);
        }

        int numCandies = candyType.length / 2;
        if (numCandies > uniqueTypes.size()){
            return uniqueTypes.size();
        }
        else{
            return numCandies;
        }
    }
}
