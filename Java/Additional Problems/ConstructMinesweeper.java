import java.util.*;
import java.lang.Math;

class ConstructMinesweeper {
    
    public static void main(String[] args) {
        int[][] field = constructField(10, 20);
        printField(field);
    }
    
    // Randomly generates a minesweeper field based on an inputeed size and number of bombs
    public static int[][] constructField(int size, int numBombs){
        if (size < 0){
            return new int[][]{};
        }
        
        // Randomly generate a board with the amount of bombs specified by 'numBombs'
        int[][] field = new int[size][size];
        if (numBombs >= size*size){
            for (int[] row : field){
                Arrays.fill(row, 9);
            }
        }
        else if (numBombs < (size * size) / 2){
            while (numBombs > 0){
                int row = (int) (Math.random() * size), col = (int) (Math.random() * size);
                if (field[row][col] == 0){
                    field[row][col] = 9;
                    numBombs--;
                }
            }
        }
        else{
            for (int[] row : field){
                Arrays.fill(row, 9);
            }
            
            int numEmpty = (size * size) - numBombs;
            while (numEmpty > 0){
                int row = (int) (Math.random() * size), col = (int) (Math.random() * size);
                if (field[row][col] == 9){
                    field[row][col] = 0;
                    numEmpty--;
                }
            }
        }
        
        for (int r = 0; r < size; r++){
            for (int c = 0; c < size; c++){
                if (field[r][c] == 9){
                    updateField(field, r, c);
                }
            }
        }
        
        return field;
    }
    
    // Updates a field to indicate when a bomb is in an adjacent square
    public static void updateField(int[][] field, int row, int col){
        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1},{1,0},{1,-1},{0,-1}};
        
        for (int[] dir : directions){
            int newR = row + dir[0];
            int newC = col + dir[1];
            
            if (Math.min(newR,newC) >= 0 && newR < field.length && newC < field[0].length && field[newR][newC] != 9){
                field[newR][newC]++;
            }
        }
    }
    
    // Prints a field
    public static void printField(int[][] field){
        for (int[] row : field){
            for (int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
