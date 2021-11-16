package graphs.misc;

import java.util.*;

public class TheLargestIsland {

  /**
    Given a two-dimensional array containing 0s and 1s, find the size of the largest island. If there is no island return 0.
    An island is a group of 1s connected vertically or horizontally.
            Example One
    Input: grid = [
            [1, 1, 0],
            [1, 1, 0],
            [0, 0, 1],
            ]
    Output: 4*/
    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        List<List<Integer>> matrixList = new ArrayList<>();

        for (Integer[] sub : matrix) matrixList.add(Arrays.asList(sub));

        System.out.println(max_island_size(matrixList));

    }


    public static int max_island_size(List<List<Integer>> grid) {
        int maxIsland = 0;
        for(int i = 0; i < grid.size(); i++){
            for (int j = 0; j < grid.get(i).size(); j++){
                if (grid.get(i).get(j) == 1){
                    int thisIsland = bfs(grid, i, j);
                    maxIsland = Math.max(maxIsland, thisIsland);
                }
            }
        }
        return maxIsland;
    }

    public static int  bfs(List<List<Integer>> grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[] xCoor = {0, 0, -1, 1};
        int[] yCoor = {-1, 1, 0, 0};
        int islandSize = 0;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()){
            int[] current = queue.remove();
            if (grid.get(current[0]).get(current[1]) == 1){
                islandSize++;
                //this works as visited
                grid.get(current[0]).set(current[1], 0);
                for(int k = 0; k < xCoor.length; k++){
                    int newX = current[0] + xCoor[k];
                    int newY = current[1] + yCoor[k];

                    if (newX >=0 && newX < grid.size() && newY >= 0 && newY < grid.get(i).size()){
                        queue.add(new int[]{newX, newY});
                    }
                }

            }
        }

        return islandSize;
    }

}
