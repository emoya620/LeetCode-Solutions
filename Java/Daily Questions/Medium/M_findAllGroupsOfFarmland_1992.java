class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> farms = new ArrayList<>();
        for (int r = 0; r < land.length; r++){
            for (int c = 0; c < land[0].length; c++){
                if (land[r][c] == 1){
                    farms.add(findCoords(r, c, land));
                }
            }
        }

        int[][] ans = new int[farms.size()][4];
        for (int i = 0; i < farms.size(); i++){
            ans[i] = farms.get(i);
        }
        return ans;
    }

    public int[] findCoords(int r, int c, int[][] land){
        int[] farmland = new int[4];
        farmland[0] = r;
        farmland[1] = c;

        int row = r;
        int col = c;

        while (row < land.length && land[row][c] == 1){
            row++;
        }

        while (col < land[0].length && land[r][col] == 1){
            col++;
        }

        farmland[2] = row - 1;
        farmland[3] = col - 1;

        for (int i = r; i < row; i++){
            for (int j = c; j < col; j++){
                land[i][j] = 0;
            }
        }

        return farmland;
    }
}
