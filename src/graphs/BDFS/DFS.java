package graphs.BDFS;

import graphs.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {
        Vertex zero = new Vertex("0");
        Vertex one = new Vertex("1");
        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex four = new Vertex("4");
        Vertex five = new Vertex("5");

        zero.addNeighbour(one);
        one.addNeighbour(two, three);
        three.addNeighbour(four);
        four.addNeighbour(five, zero);

        List<Vertex> visited = new ArrayList<>();
        dfs(zero, visited);


    }

    public static void dfs(Vertex vertex, List<Vertex> visited){

        //for loop works as a return statement once all neighbours visited and explored for will return
        visited.add(vertex);
        System.out.println(vertex);
        for (Vertex v: vertex.getNeighbours()){
            if (!visited.contains(v)){
                dfs(v, visited);
            }
        }
    }

    /**
     * We add new state is explored which will show if all neighbours of this vertex are explored
     * @param vertex
     * @param visited
     */
    public static void dfs(Vertex vertex, List<Vertex> visited, List<Vertex> explored){

        //for loop works as a return statement once all neighbours visited and explored for will return
        visited.add(vertex);
        System.out.println(vertex);
        for (Vertex v: vertex.getNeighbours()){
            if (!visited.contains(v)){
                dfs(v, visited);
            }
        }

        //Vertex considered explored when all it's children also visited and explored
        explored.add(vertex);
    }
}
