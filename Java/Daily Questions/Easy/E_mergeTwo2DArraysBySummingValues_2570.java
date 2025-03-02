// Time Complexity: O(n + m) | Space Complexity: O(n + m)
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> mergedList = new ArrayList<>();
        int index1 = 0, index2 = 0;
        
        while (index1 < nums1.length && index2 < nums2.length){
            if (nums1[index1][0] == nums2[index2][0]){
                mergedList.add(new int[]{nums1[index1][0], nums1[index1][1] + nums2[index2][1]});
                index1++;
                index2++;
            }
            else if (nums1[index1][0] < nums2[index2][0]){
                mergedList.add(nums1[index1]);
                index1++;
            }
            else{
                mergedList.add(nums2[index2]);
                index2++;
            }
        }

        while (index1 < nums1.length){
            mergedList.add(nums1[index1]);
            index1++;
        }

        while (index2 < nums2.length){
            mergedList.add(nums2[index2]);
            index2++;
        }

        int[][] answer = new int[mergedList.size()][2];
        for (int i = 0; i < answer.length; i++){
            answer[i] = mergedList.get(i);
        }

        return answer;
    }
}
