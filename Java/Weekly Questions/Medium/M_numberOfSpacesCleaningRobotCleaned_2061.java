class Solution {
    public int numberOfCleanRooms(int[][] room) {
        int numCleanSpaces = 0;
        int degrees = 90;
        int turns = 0;
        int noCleanSpaces = 0;

        int r = 0;
        int c = 0;
        int curCleanSpaces = 0;
        while (turns < 4 && noCleanSpaces < 4) {
            while (degrees == 90){
                if (c == room[0].length){
                    degrees += 90;
                    c--;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if(room[r][c] == 1){
                    degrees += 90;
                    c--;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if (room[r][c] == 0){
                    curCleanSpaces++;
                    room[r][c] = 2;
                }
                c++;
            }
            numCleanSpaces += curCleanSpaces;
            curCleanSpaces = 0;

            

            while (degrees == 180){
                if (r == room.length){
                    degrees += 90;
                    r--;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if(room[r][c] == 1){
                    degrees += 90;
                    r--;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if (room[r][c] == 0){
                    curCleanSpaces++;
                    room[r][c] = 2;
                }
                r++;
            }
            numCleanSpaces += curCleanSpaces;
            curCleanSpaces = 0;

            while (degrees == 270){
                if (c == -1){
                    degrees += 90;
                    c++;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if(room[r][c] == 1){
                    degrees += 90;
                    c++;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if (room[r][c] == 0){
                    curCleanSpaces++;
                    room[r][c] = 2;
                }
                c--;
            }
            numCleanSpaces += curCleanSpaces;
            curCleanSpaces = 0;

            while (degrees == 360){
                if (r == -1){
                    degrees = 90;
                    r++;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if(room[r][c] == 1){
                    degrees = 90;
                    r++;

                    if (curCleanSpaces == 0){
                        turns++;
                        noCleanSpaces++;
                    }
                    else{
                        turns = 0;
                        noCleanSpaces = 0;
                    }
                    continue;
                }
                else if (room[r][c] == 0){
                    curCleanSpaces++;
                    room[r][c] = 2;
                }
                r--;
            }
            numCleanSpaces += curCleanSpaces;
            curCleanSpaces = 0;
        }

        return numCleanSpaces;
    }
}
