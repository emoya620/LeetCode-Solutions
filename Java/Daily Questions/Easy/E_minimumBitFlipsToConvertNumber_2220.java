class Solution {
    public int minBitFlips(int start, int goal) {
        int numBitFlips = 0;
        int xor = start ^ goal;
        while (xor != 0){
            numBitFlips += xor & 1;
            xor >>= 1;
        }
        return numBitFlips;
    }
}
