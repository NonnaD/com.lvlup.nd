package recursion;

import java.util.Arrays;

public class NQueen {
    public static void main(String[] args) {
        int[][] arr = nqueenSolution(4);
        Arrays.stream(arr).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }

    public static int[][] nqueenSolution(int n){
      int[][] queens = new int[n][n];
      queens[0] = new int[]{-1,-1};
      if (nqueen(queens, n, 0)){
          return queens;
      }else {
          return new int[0][0];
      }
    }

    static boolean nqueen(int[][] qs, int n, int row) {
        if(row == n) return true;

        //once recursion returned from inside out
        //the function will continue from this point
        //it will increase the col and place q at new cell
        for (int col = 0; col < n; col++){
            boolean isQPlaced = true;

            //we already placed row number of queens 1 - queen per column
            for (int q = 0; q < row; q++) {
                if(qs[q][0] == row ||
                   col == qs[q][1] ||
                   row + col == qs[q][0] + qs[q][1] ||
                   row - col == qs[q][0] - qs[q][1]){
                    isQPlaced = false;
                    break;
                }
            }
            if (isQPlaced){
                qs[row] = new int[]{row, col};
                if (nqueen(qs, n, row + 1)){
                    return true;
                }
            }
        }
        return false;
    }

}
