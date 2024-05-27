class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }

        Arrays.sort(diff);
        
        int j = n - 1;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            while (j > i && diff[i] + diff[j] > 0) {
                j--;
            }
            if (j >= i) {
                cnt += n - j - 1;
            } else {
                cnt += n - i - 1;
            }
        }
        return cnt;
    }
}
