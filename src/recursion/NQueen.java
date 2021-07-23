package recursion;

import java.util.Arrays;

public class NQueen {


    public static void main(String[] args) {
        int[][] arr = find_all_arrangements(4);
        Arrays.stream(arr).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }

    /**
     *
     * Given an integer n, find all the possible ways to position n queens
     * on an n×n chessboard so that no two queens attack each other.
     * A queen in chess can move horizontally, vertically, or diagonally.
     *
     * NOTE: Queens, rows and columns all equals n
     */
    static int[][] find_all_arrangements(int n) {
        int[][] arr = new int[n][n];
        if (nqueen(n, 0, arr)){
            return arr;
        }else return new int[0][0];
    }

    public static boolean nqueen(int n, int row, int[][] arr) {
        //if function did not return false up till this point, it means we have found
        //place for each queen on the board
        if (n == row) return true;
        //we will use recursion to move between rows
        //we enter starting by row=0
        //for each row I want to iterate columns
        for (int col = 0; col < n; col++){
            boolean isValid = true;
            //i want to check (INSPECT COLUMN) if I can place my queen at given combination row + column
            // i want to check for all queens added before this queen
            //since 1 row can place only 1 queen, it means we cannot have queens more or less row
            for(int queen = 0; queen < row; queen++) {
                if (arr[queen][0] == row ||
                        arr[queen][1] == col ||
                        arr[queen][0] - arr[queen][1] == row - col ||
                        arr[queen][0] + arr[queen][1] == row + col){
                    isValid =  false;
                    //i break out of loop
                    //if my column check failed for first previously added queen
                    //i dont want to check further
                    //i want to break out of queens loop and check next row;
                    break;
                }
            }
            //if one of our rows passed previous test
            //and did not become false
            //we want to add our queen at this position
            if(isValid){
                //Problem i dont know in which position do i place my new result
                //i assume if 1 queen per 1 row added
                //a already have row num of queens
                arr[row] = new int[]{row, col};

                //the most interesting part
                //actual backtracking happens here
                //when i call nqueen form here
                //it goes inside itself
                //since a call recursion att the en of function it will execute from
                //row = 0 -> row = 1 -> row = 2 -> row = 3 -> return true
                //row = 0 -> row = 1 <- (false) row = 2 <- (true) row = 3 <- true
                //row = 0 -> row = 1 -> (false) row = 2 <- (true) row = 3 <- true
                //IMPORTANT: When we break out of nqueen() recursion with false
                //we do not go to the start of function we are inside the loop
                // for (int col = 0; col < row; col++){
                // we return at this point
                // col ++ and we try to place our previous queen on position col+1
                //do not use ++row use row + 1 instead
                if(nqueen(n, row+1, arr)){
                    return true;
                }
            }
        }
        //if true was not return up till this point
        //this row failed to add THE QUEEN
        return false;
    }


}
