class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        Queue<Integer> indices = new LinkedList<>();

        for (int i = 0; i < deck.length; i++){
            nums.add(deck[i]);
            indices.add(i);
        }

        int[] ans = new int[deck.length];
        while (!nums.isEmpty()){
            int index = indices.remove();
            ans[index] =  nums.remove();

            if (indices.size() != 0){
                int nextIndex = indices.remove();
                indices.add(nextIndex);
            }
        }
        return ans;
    }
}
