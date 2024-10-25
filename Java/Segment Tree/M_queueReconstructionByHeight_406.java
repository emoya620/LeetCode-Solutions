// Solution taken from LeetCode forums. I don't fully understand yet
class Solution {
    private int[] segmentTree;

    private void buildSegmentTree(int index, int low, int high){
        if (low == high){
            segmentTree[index] = 1;
            return;
        }

        int mid = (low + high) / 2;
        buildSegmentTree(2*index+1, low, mid);
        buildSegmentTree(2*index+2, mid+1, high);
        segmentTree[index] = segmentTree[2*index + 1] + segmentTree[2*index + 2];
    }

    private int queryAndUpdate(int index, int low, int high, int range){
        if (low == high){
            segmentTree[index] = 0;
            return low;
        }

        int mid = (low+high) / 2;
        int leftIndex = (2*index) + 1, rightIndex = (2*index) + 2;
        int res = 0;
        if (range <= segmentTree[leftIndex]){
            res = queryAndUpdate(leftIndex, low, mid, range);
        }
        else{
            res = queryAndUpdate(rightIndex, mid+1, high, range - segmentTree[leftIndex]);
        }

        segmentTree[index] = segmentTree[leftIndex] + segmentTree[rightIndex];
        return res;
    }
    
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        this.segmentTree = new int[n*4];
        buildSegmentTree(0, 0, n-1);

        Arrays.sort(people, (a,b) -> (a[0] == b[0] ? b[1]-a[1] : a[0] - b[0]));
        
        int[][] ans = new int[n][2];
        for (int[] val : people){
            int index = queryAndUpdate(0, 0, n-1, val[1] + 1);
            ans[index] = val;
        }
        return ans;
    }
}
