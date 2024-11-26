class Solution {
    // Time Complexity: O(n + m) | Space Complexity: O(n)
    public int findChampion(int n, int[][] edges) {
        int[] incomingEdges = new int[n];

        for (int[] edge : edges){
            incomingEdges[edge[1]]++;
        }

        int champ = -1;
        int numChamps = 0;
        for (int i = 0; i < n; i++){
            if (incomingEdges[i] == 0){
                champ = i;
                numChamps++;
            }
        }
        return (numChamps == 1) ? champ : -1;
    }
}
