package graphs.misc;

import java.util.*;

public class CountIslands {
    /**
     * Count Islands
     * Given a two-dimensional boolean matrix, find the number of islands.
     * An island is a group of connected 1s or a standalone 1. A cell in the matrix can be connected to up to 8 neighbors: 2 vertical, 2 horizontal and 4 diagonal.
     * Example
     * Input:
     * [
     * [1, 1, 0, 0, 0],
     * [0, 1, 0, 0, 1],
     * [1, 0, 0, 1, 1],
     * [0, 0, 0, 0, 0],
     * [1, 0, 1, 0, 1]
     * ]
     * Output: 5
     * (0 0), (0 1), (1 1) and (2 0) make an island.
     * (1 4), (2 4) and (2 3) make an island.
     * (4 0) makes an island.
     * (4 2) makes an island
     * (4 4) makes an island.
     * Notes
     * <p>
     * Input Format: Function has one argument, a two-dimensional integer matrix. All the values in the matrix are either 0 or 1.
     * Output Format: Return an integer, the number of islands of 1s.
     */

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        List<List<Integer>> matrixList = new ArrayList<>();

        for (Integer[] sub : matrix) matrixList.add(Arrays.asList(sub));

        System.out.println(count_islands(matrixList));
    }

    public static int count_islands(List<List<Integer>> matrix) {

        int numIslands = 0;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    numIslands++;
                    bfs(matrix, i, j);
                }
            }
        }
        return numIslands;
    }


    public static void bfs(List<List<Integer>> matrix, int i, int j) {
        Queue<int[]> coord = new LinkedList<>();
        int[] xCoor = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] yCoor = {-1, 1, 0, -1, 1, -1, 0, 1};
        coord.add(new int[]{i, j});

        while (!coord.isEmpty()) {
            int[] current = coord.remove();
            if (matrix.get(current[0]).get(current[1]) != 0) {

                //this line works as isVisited arr
                //once we removed element from queue -> set value to 0
                // so next time if statement encounter this value it's not explore it but skip
                matrix.get(current[0]).set(current[1], 0);
                for (int k = 0; k < xCoor.length; k++) {
                    int newX = current[0] + xCoor[k];
                    int newY = current[1] + yCoor[k];

                    if (newX >= 0 && newX < matrix.size() && newY >= 0 && newY < matrix.get(i).size()) {
                        coord.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
