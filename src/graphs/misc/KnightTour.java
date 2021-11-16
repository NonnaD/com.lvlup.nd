package graphs.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightTour {

/**    You are given a rows * cols chessboard and a knight that moves like in normal chess. Currently knight is at starting position denoted by start_row th row and start_col th col, and want to reach at ending position denoted by end_row th row and end_col th col.  The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.
    start_row, start_col, end_row and end_col are 0-indexed.

    Input:
    rows = 5
    cols = 5
    start_row = 0
    start_col = 0
    end_row = 4
    end_col = 1

    Output: 3

 NOTE: Knight moves L shape +-2 up/down or left or right +-1 up*/


    public static void main(String[] args) {

        System.out.println(find_minimum_number_of_moves(5,5,1,1,4,4));
    }


    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        if(start_row == end_row && start_col == end_col) return 0;
        Queue<Integer[]> cors = new LinkedList<>();
        //if vertex with coordinates [x][y] visited set value to 1 by default all init to 0
        int[][] visited = new int[rows][cols];
        cors.add(new Integer[]{start_row, start_col});
        //list all of move combinations for knight
        int[] corX = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] corY = {-1, 1, -1, 1, -2, 2, -2, 2};
        int level = 1;

        while (!cors.isEmpty()){
            int qSize = cors.size();
            for (int i = 0; i < qSize; ++i){
                Integer[] current = cors.remove();
                for (int j = 0; j < corX.length; j++){

                    //each removed Vertex(coordinates) will have corX.lengt of possible options to move
                    int newX = current[0] + corX[j];
                    int newY = current[1] + corY[j];


                    if (newX < rows && newX >= 0 && newY < cols && newY >= 0){
                        if(visited[newX][newY] == 0){
                            if (newX == end_row && newY == end_col) return level;
                            cors.add(new Integer[]{newX, newY});
                            visited[newX][newY] = 1;
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }

}
