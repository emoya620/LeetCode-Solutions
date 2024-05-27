class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int left = 0;
        int right = height.length - 1;
        while (left < right){
            if (leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                if (leftMax - height[left] > 0){
                    totalWater += leftMax - height[left];
                }
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                if (rightMax - height[right] > 0){
                    totalWater += rightMax - height[right];
                }
            }
        }
        return totalWater;
    }
}
