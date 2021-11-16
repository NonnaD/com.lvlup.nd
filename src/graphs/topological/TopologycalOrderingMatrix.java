package graphs.topological;

import java.util.ArrayList;
import java.util.List;

public class TopologycalOrderingMatrix {

    public static void main(String[] args) {

        int[][] adjacencyMatrixGraph = new int[][]{
                {0,0,0,0,0,0,0,0},
                {0,0,1,1,0,0,0,0},
                {0,0,0,0,0,1,1,0},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0}
        };

        List<Integer> visited = new ArrayList<>();
        topologycal(adjacencyMatrixGraph, 1, visited);
        System.out.println(visited.toString());
    }

    public static void topologycal(int[][] graph, int vertex, List<Integer> visited){

        for (int i = 0; i < graph[vertex].length; i++){
            if (!visited.contains(vertex)){
                if (graph[vertex][i] == 1){
                    topologycal(graph, i, visited);
                }
            }
        }

        if (!visited.contains(vertex))  visited.add(0, vertex);
    }

}
