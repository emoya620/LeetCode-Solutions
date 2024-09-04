class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0;
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int maxDist = 0;

        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles){
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int cmd : commands){
            if (cmd == -1){
                dir = (dir + 1) % 4; 
            }
            else if (cmd == -2) {
                dir = (dir + 3) % 4;
            }
            else{
                for (int i = 0; i < cmd; i++){
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    if (obstacleSet.contains(newX + "," + newY)){
                        break;
                    }
                    x = newX;
                    y = newY;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        return maxDist;
    }
}
