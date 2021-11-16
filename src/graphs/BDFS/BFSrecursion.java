package graphs.BDFS;

import graphs.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSrecursion {

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

        bfs(a);
    }

    public static void bfs(Vertex vertex){
        Queue<Vertex> q = new LinkedList<>();
        List<Vertex> visited = new ArrayList<>();
        q.add(vertex);
        bfsHelper(vertex, q, visited);
    }

    public static void bfsHelper(Vertex vertex, Queue<Vertex> q, List<Vertex> visited) {
        if (q.isEmpty()) return;
        Vertex v = q.remove();
        visited.add(v);
        System.out.println(v.getValue());
        for (Vertex n : v.getNeighbours()) {
            if (!isVisited(n, visited)) {
                q.add(n);
            }
            bfsHelper(n, q, visited);
        }
    }

    public static boolean isVisited(Vertex vertex, List<Vertex> visited){
        return visited.contains(vertex);
    }
}
