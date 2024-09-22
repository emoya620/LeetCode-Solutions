class Solution {
    public int getReqNum(long a, long b, long n){
        int gap = 0;
        while (a <= n){
            gap += Math.min(n+1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }

    public int findKthNumber(int n, int k) {
        long curNum = 1;
        for (int i = 1; i < k;){
            int req = getReqNum(curNum, curNum + 1, n);
            if (i + req <= k){
                i += req;
                curNum++;
            }
            else{
                i++;
                curNum *= 10;
            }
        }
        return (int)curNum;
    }
}
