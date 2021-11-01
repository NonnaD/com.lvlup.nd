package graphs.BDFS;

import java.util.ArrayList;
import java.util.List;

public class DFSMatrix {
    public static void main(String[] args) {
        //int[0][0] are 0's - we do nor have 0 Vertex so we set all to 0
        int[][] adjacencyMatrixGraph = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,1,1,1,0,0,0},
                {0,1,0,1,0,0,0,0},
                {0,1,1,0,1,0,0,0},
                {0,1,0,1,0,1,0,0},
                {0,0,0,1,1,0,1,1},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0}
        };

        List<Integer> visited = new ArrayList<>();

        dfs(adjacencyMatrixGraph, 1, visited);
    }

    //When we find first neighbour of our vertex we continue exploring neighbour
    public static void dfs(int[][] graph, int vertex, List<Integer> visited){
        if (!visited.contains(vertex)){
            System.out.println(vertex);
            visited.add(vertex);
            for (int i = 1; i <= graph.length - 1; i++){
                if (graph[vertex][i] == 1){
                    dfs(graph, i, visited);
                }
            }
        }
    }


}
