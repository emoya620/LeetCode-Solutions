class Solution {
    // Time Complexity: O (N^2) | Space Complexity: O(N * L)
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> answer = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < folder.length){
            String curFolder = folder[left];
            answer.add(curFolder);
            left++;
            right++;
            while (right < folder.length && curFolder.length() + 1 <= folder[right].length() 
                    && folder[right].substring(0, curFolder.length() + 1).equals(curFolder + "/")){
                right++;
            }
            left = right;
        }
        return answer;
    }
}
