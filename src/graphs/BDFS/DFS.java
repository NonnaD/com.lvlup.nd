package graphs.BDFS;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        a.addNeighbour(b,c);
        b.addNeighbour(a,c,d);
        c.addNeighbour(a,b,d);
        d.addNeighbour(e);
        e.addNeighbour(d);

        List<Vertex> visited = new ArrayList<>();
        dfs(a, visited);
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
}
