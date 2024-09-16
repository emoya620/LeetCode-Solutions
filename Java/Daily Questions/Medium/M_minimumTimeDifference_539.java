class Solution {
    // Time Complexity: O(n * log(n)) | Space Complexity: O(n)
    public int findMinDifference(List<String> timePoints) {
        // Convert all time points into their total minutes
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++){
            String t = timePoints.get(i);
            int hour = Integer.parseInt(t.substring(0,2));
            int min = Integer.parseInt(t.substring(3,5));
            minutes[i] = hour * 60 + min;
        }

        // Sort array from smallest to largest
        Arrays.sort(minutes);

        // Calculate the minimum minutes difference of all adjacent values
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++){
            minDiff = Math.min(minDiff, minutes[i+1] - minutes[i]);
        }
        return Math.min(minDiff, (24 * 60) - minutes[minutes.length - 1] + minutes[0]);
    }
}
