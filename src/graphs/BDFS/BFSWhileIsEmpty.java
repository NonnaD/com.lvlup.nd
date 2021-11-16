package graphs.BDFS;

import graphs.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSWhileIsEmpty {
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
        bfs(a, visited);
    }

    public static void bfs(Vertex vertex, List<Vertex> visited){
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()){
            Vertex v = queue.remove();
            System.out.println(v);
            for (Vertex n: v.getNeighbours()){
                if (!visited.contains(n)){
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
    }

}
