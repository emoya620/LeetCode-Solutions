/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public int findCelebrity(int n) {
        int celebCandidate = 0;
        for (int i = 1; i < n; i++){
            if (knows(celebCandidate, i)){
                celebCandidate = i;
            }
        }

        for (int i = 0; i < n; i++){
            if (i != celebCandidate && (knows(celebCandidate, i) || !knows(i, celebCandidate))){
                return -1;
            }
        }
        return celebCandidate;
    }
}
