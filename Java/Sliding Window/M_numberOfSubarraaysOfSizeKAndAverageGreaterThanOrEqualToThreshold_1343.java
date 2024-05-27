class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int left = 0;

        int curSum = 0;
        for (int right = 0; right < arr.length; right++){
            if (right < k){
                curSum += arr[right];
                continue;
            }

            
            if (curSum / k >= threshold){
                ans++;
            }
            curSum -= arr[left];
            curSum += arr[right];
            left++;
        }

        if (curSum / k >= threshold){
            ans++;
        }

        return ans;
    }
}
