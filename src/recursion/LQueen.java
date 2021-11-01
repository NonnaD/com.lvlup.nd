package recursion;

import java.util.Arrays;

public class LQueen {

    public static void main(String[] args) {
        int[][] arr = nqueenSolution(4);
        Arrays.stream(arr).forEach(ar -> System.out.println(Arrays.toString(ar)));
    }

    public static int[][] nqueenSolution(int n){
        int[][] queens = new int[n][2];
        queens[0] = new int[]{-1,-1};
        if (nqueen(queens, n, 0, 0)){
            return queens;
        }else {
            return new int[0][0];
        }
    }

    public static boolean nqueen(int[][] queens, int n , int col, int row){
        if (n == row) return true;
        //for each column
       for (int i = col; i < n; i++){
           boolean underAttack = false;

           //for each row 1 queen is placed so we can say we have as many queens as rows
           for (int q = row; q > 0; q++){
               //queens[queen object] = new int{col, row}
               if(queens[q][0] == row ||
                       i == queens[q][1] ||
                       row + col == queens[q][0] + queens[q][1] ||
                       row - col == queens[q][0] - queens[q][1]){
                   underAttack = true;
                   break;
               }
           }

           if (underAttack){
               queens[row] = new int[]{row, col};
               if (nqueen(queens, n, col, row + 1)){
                   return true;
               }
           }
       }
       return false;
    }
}
