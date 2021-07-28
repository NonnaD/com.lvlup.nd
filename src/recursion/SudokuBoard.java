package recursion;

import java.util.Arrays;

public class SudokuBoard {

    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{8, 4, 9, 0, 0, 3, 5, 7, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {7, 0, 0, 0, 9, 0, 0, 8, 3},
                {0, 0, 0, 9, 4, 6, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0, 4, 0},
                {0, 0, 6, 8, 7, 2, 0, 0, 0},
                {5, 7, 0, 0, 1, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 2, 1, 7, 0, 0, 8, 6, 5}};



        sudoku(arr);
        for (int[] ar : arr) {
            System.out.println(Arrays.toString(ar));
        }
    }


    private static boolean sudoku(int[][] arr) {
        for (int row = 0; row < arr.length; row++){
            for (int col =0; col < arr.length; col++){
                if (arr[row][col] == 0){
                    for (int potentialNumber = 1; potentialNumber <= arr.length; potentialNumber++){
                        if(isValid(arr, col, row, potentialNumber)){
                            arr[row][col] = potentialNumber;
                            //when we call sudoku recursively we do not provide any num to stop the recursion
                            //basically what stops the recursion is this line   if (arr[row][col] == 0){
                            //each time we call sudoku() it will fill i cell
                            //when n-1 cells are filled and we call this recursion no 0 cells left
                            //function will proceed to the very end and return true
                            if(sudoku(arr)){
                                return true;
                            }else {
                                arr[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



    private static boolean isValid(int[][] arr, int col, int row, int val){
       return isValidColumn(arr, col, val)
                && isValidRow(arr, row, val)
                && isValidBox(arr, col, row, val);

    }

    private static boolean isValidColumn(int[][] arr, int col, int value){
        for (int i = 0; i < arr.length; i++){
            if (arr[i][col] == value) return false;
        }
        return true;
    }

    private static boolean isValidRow(int[][] arr, int row, int value){
        for (int i = 0; i < arr.length; i++){
            if (arr[row][i] == value) return false;
        }
        return true;
    }

    private static boolean isValidBox(int[][] arr, int col, int row, int value){
        int boxColStarts = col - col%3;
        int boxRowStarts = row - row%3;
        for (int i = boxRowStarts; i < boxRowStarts + 3; i++){
            for (int k = boxColStarts; k < boxColStarts+3; k++){
                if (arr[i][k] == value) return false;
            }
        }
        return true;
    }
}
