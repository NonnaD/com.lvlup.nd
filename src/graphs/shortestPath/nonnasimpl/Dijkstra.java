package graphs.shortestPath.nonnasimpl;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * https://www.youtube.com/watch?v=pVfj6mxhdMw
     *
     */
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.setNeighbours(b, 2);
        a.setNeighbours(c, 4);

        b.setNeighbours(c, 1);
        b.setNeighbours(d, 7);

        c.setNeighbours(e, 3);
        d.setNeighbours(f, 1);
        e.setNeighbours(d, 2);
        e.setNeighbours(f, 5);

        dijkstra(a);
        printShortestPath(a, f);
    }

    public static void dijkstra(Vertex a){
        a.setDistance(0);

        /**
         * Main idea of Dijkstra's algo -> each next Vertex should be the neighbour of current vertex with the shortest path
         * Works for: Directed and undirected - Non-Negative edges - Greedy Algo - SSSP algo
         *
         * Time Complexity of Dijkstra's Algorithm is O ( V 2 ) but with min-priority queue it drops down to O (V + E * l o g V ) .
         *
         * Priority Queue will return Vertex with min distance value - PriorityQueue works as a minheap
         * Because we provided Comparator implementation in Vertex class
         */
        //Instead of implementing comparator witin Vertex class we can provide it as a FI in PQ
        PriorityQueue<Vertex> queue = new PriorityQueue<>((i , j) -> i.distance - j.distance);
        queue.add(a);

        while (!queue.isEmpty()){
            Vertex current = queue.poll();
            current.setVisited(true);

            for (Vertex n: current.getNeighbours().keySet()) {
                if (!n.isVisited()){
                    //edge relaxing if current neighbour vertex distance > precessor vertex distance + edge weight
                    //replace old distance by new distance
                    int newDistance = current.getDistance() + current.getNeighbours().get(n);
                    if (newDistance < n.getDistance()){
                        n.setDistance(newDistance);
                        n.setPredecessor(current);
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void printShortestPath(Vertex source, Vertex destination){
        if (destination.getValue().equals(source.getValue())){
            System.out.print(source.getValue() + ", ");
            return;
        }
        printShortestPath(source, destination.getPredecessor());
        System.out.print(destination.getValue() + " ,");
    }
}
