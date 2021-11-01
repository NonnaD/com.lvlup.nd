package graphs.BDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFSMatrix {

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


        bfs(adjacencyMatrixGraph, 1);
    }

    //NOTE: Verex value here is index of array graph[VertexValue][] and neighbours for it ar indexes inside this array
    //Example: for vertex 1 {0,0,1,1,1,0,0,0} neibghours are 2,3,4
    public static void bfs(int[][] graph, int vertexIndex){

        Queue<Integer> queue = new PriorityQueue();
        List<Integer> visited = new ArrayList<>();
        queue.add(vertexIndex);
        visited.add(vertexIndex);

        while (!queue.isEmpty()){
            int v = queue.remove();
            System.out.println(v);
            for (int i = graph[0].length - 1; i > 0; i--){
                if(!visited.contains(i)){
                    if(graph[v][i] == 1) {
                        queue.add(i);
                        visited.add(i);
                    }
                }
            }
        }
    }
}
