package miscel;

import java.util.HashMap;

public class PrintGraphParts {

    public static void main(String[] args) {
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

        printUpperLeftTriangle(adjacencyMatrixGraph);
        System.out.println();
        HashMap<Integer, Integer> cache = new HashMap<>();
        printUpperRightWithRecursion(adjacencyMatrixGraph, 0, 0, cache);

        cache.forEach((key, value) -> System.out.println(key +  " " + value));
    }

    public static void printUpperLeftTriangle(int[][] graph){
        for(int i = 0; i < graph.length; i++){
            for (int k = 0; k <= i; k++){
                System.out.print(graph[i][k]);
            }
            System.out.println();
        }
    }

    //dynamic programming required here
    public static void printUpperRightWithRecursion(int[][] graph, int i, int k, HashMap<Integer, Integer> cache){

        if (cache.containsKey(i) && cache.get(i) == k) return;
        cache.put(i, k);
        
        if (i >= graph.length - 1){
            System.out.println();
            return;
        }
        if(k >= graph.length - 1  || i >= graph.length - 1){
            System.out.print(graph[i][k]);
            return;
        }

        if (i < graph.length - 1)printUpperRightWithRecursion(graph, i + 1, k, cache);
        if (k < graph.length - 1)printUpperRightWithRecursion(graph, i, k+1,cache);

    
    }


}
