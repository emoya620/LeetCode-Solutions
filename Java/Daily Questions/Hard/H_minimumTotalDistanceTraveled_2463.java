// Solution taken from LeetCode forums; I don't fully understand this solution yet
class Solution {
    // Time Complexity: O(m * n^2) | Space Complexity: O(m + S)
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory){
            for (int i = 0; i < f[1]; i++){
                factoryPositions.add(f[0]);
            }
        }

        int robotCount = robot.size(), factoryCount = factoryPositions.size();
        long[] next = new long[factoryCount + 1];
        long[] current = new long[factoryCount + 1];

        for (int i = robotCount - 1; i >= 0; i--){
            if (i != robotCount - 1){
                next[factoryCount] = (long) 1e12;
            }
            current[factoryCount] = (long) 1e12;
            
            for (int j = factoryCount - 1; j >= 0; j--){
                long assign = Math.abs((long) robot.get(i) - factoryPositions.get(j)) + next[j+1];
                long skip = current[j+1];
                current[j] = Math.min(assign, skip);
            }
            System.arraycopy(current, 0, next, 0, factoryCount + 1);
        }
        return current[0];
    }
}
