package graphs.matrix;

import java.util.*;

public class Matrix01 {
   /** 542. 01 Matrix
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
    The distance between two adjacent cells is 1.
    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
    Output: [[0,0,0],[0,1,0],[0,0,0]]

    My observation: for shortest path problems in matrix. like this problem or  994. Rotting Oranges
    BFS is a better solution TC is O(N * M)
    This kind of problem can also be solved using DP(tabulation) approach  or BFS with memoization
    */

   // We can see that the distance of all zero-cells are 0.
   // We process zero-cells first, then we use queue data structure to keep the order of processing cells, so that cells which have the smaller distance will be processed first. Then we expand the unprocessed neighbors of the current processing cell and push into our queue.
  // Afterall, we can achieve the minimum distance of all cells in our matrix.
   public static int[][] updateMatrix(int[][] mat) {
       Queue<int[]> q = new LinkedList();
       int[] x = new int[]{1, -1, 0, 0};
       int[] y = new int[]{0, 0, 1, -1};

       for(int i = 0; i < mat.length; i++)
           for(int j = 0; j < mat[0].length; j++){
               if(mat[i][j] == 0) q.add(new int[]{i, j});
               else mat[i][j] = -1; // Marked as not processed yet
           }

       while(!q.isEmpty()){
           int[] curr = q.poll();
           int r = curr[0], c = curr[1];
           for(int k = 0; k < x.length; k++){
               int newX = r + x[k], newY = c + y[k];
               //mat[newX][newY]!=-1 guarantees we do not visit already visited
               if(newX < 0 || newY < 0 || newX >= mat.length || newY >= mat[0].length || mat[newX][newY]!=-1) continue;
               mat[newX][newY] = mat[curr[0]][curr[1]] + 1;
               q.offer(new int[]{newX, newY});
           }
       }

       return mat;
   }


    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,0}, {1,0}};
        int[][] res = updateMatrix(mat);
        Arrays.stream(res).forEach(System.out::println);


    }
}
