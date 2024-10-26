// This solution is from LeetCode forums; I still don't fully understand it
class Solution {
    int N = 1_00_001;
    int seg[];
    
    public void update(int idx, int x, int low, int high, int i){
        if (low == high){
            seg[idx] = x;
            return;
        }

        int mid = low + (high - low) / 2;
        if (i <= mid){
            update(2 * idx + 1, x, low, mid, i);
        }
        else{
            update(2 * idx + 2, x, mid+1, high, i);
        }
        seg[idx] = Math.max(seg[2*idx+1], seg[2*idx+2]);
    }

    public int query(int l, int r, int low, int high, int idx){
        if (l > high || r < low){
            return Integer.MIN_VALUE;
        }
        if (low >= l && high <= r){
            return seg[idx];
        }
        int mid = low + (high - low) / 2;
        int left = query(l, r, low, mid, 2 * idx + 1);
        int right = query(l, r, mid + 1, high, 2 * idx + 2);
        return Math.max(left, right);
    }

    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        seg = new int[N * 4];
        for (int i = 0; i < n; i++){
            int l = Math.max(0, nums[i] - k);
            int r = nums[i] - 1;
            int res = query(l, r, 0, N-1, 0) + 1;
            max = Math.max(max, res);
            update(0, res, 0, N-1, nums[i]);
        }
        return max;
    }
}
