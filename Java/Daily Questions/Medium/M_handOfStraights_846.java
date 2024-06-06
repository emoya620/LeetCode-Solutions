class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);

        for (int i = 0; i < n; i++){
            if (hand[i] >= 0){
                if (!findGroup(hand, groupSize, i, n)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findGroup(int[] hand, int groupSize, int i, int n){
        int nextVal = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i++;

        while (i < n && count < groupSize){
            if (hand[i] == nextVal){
                nextVal = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }

        if (count != groupSize){
            return false;
        }
        else{
            return true;
        }
    }
}
