class Solution {
    // Time Complexity: O((m*n)! * (m*n)) | Space Complexity: O((m*n)!)
    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][]{
            {1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}
        };

        String target = "123450";
        StringBuilder startState = new StringBuilder();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 3; j++){
                startState.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList();
        queue.add(startState.toString());
        visited.add(startState.toString());

        int moves = 0;
        while (!queue.isEmpty()){
            int length = queue.size();

            while (length > 0){
                String currentState = queue.poll();

                if (currentState.equals(target)){
                    return moves;
                }

                int zeroPos = currentState.indexOf('0');
                for (int newPos : directions[zeroPos]){
                    String newState = swap(currentState, zeroPos, newPos);

                    if (visited.contains(newState)){
                        continue;
                    }

                    visited.add(newState);
                    queue.add(newState);
                }
                length--;
            }
            moves++;
        }
        return -1;
    }

    public String swap(String s, int zeroPos, int newPos){
        StringBuilder temp = new StringBuilder(s);
        temp.setCharAt(zeroPos, s.charAt(newPos));
        temp.setCharAt(newPos, s.charAt(zeroPos));
        return temp.toString();
    }
}
