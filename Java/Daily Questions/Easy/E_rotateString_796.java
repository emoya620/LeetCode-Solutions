class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        
        int left = 0;
        int goalPointer = 0;

        while (goalPointer < goal.length()){
            
            if (s.charAt(0) == goal.charAt(goalPointer) && isValidString(s, goal, goalPointer)){
                return true;
            }
            goalPointer++;
            System.out.println(goalPointer);
        }
        return false;
    }

    public boolean isValidString(String s, String goal, int goalIndex){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != goal.charAt(goalIndex)){
                return false;
            }
            goalIndex = (goalIndex + 1 == goal.length()) ? 0 : goalIndex + 1;
        }
        return true;
    }
}
