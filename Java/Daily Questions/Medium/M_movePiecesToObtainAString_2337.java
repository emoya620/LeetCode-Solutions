class Solution {
    // Time Complexity: O(n) | Space Complexity: O(1)
    public boolean canChange(String start, String target) {
        int length = start.length();
        int sIndex = 0, tIndex= 0;
        while (sIndex < length || tIndex < length){
            while (sIndex < length && start.charAt(sIndex) == '_'){
                sIndex++;
            }

            while (tIndex < length && target.charAt(tIndex) == '_'){
                tIndex++;
            }

            if (sIndex == length || tIndex == length){
                return sIndex == length && tIndex == length;
            }

            if (start.charAt(sIndex) != target.charAt(tIndex) || 
                (start.charAt(sIndex) == 'L' && sIndex < tIndex) || 
                (start.charAt(sIndex) == 'R' && sIndex > tIndex)){
                    return false;
            }

            sIndex++;
            tIndex++;
        }
        return true;
    }
}
