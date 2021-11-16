package graphs.topological;

import graphs.BDFS.WeightedGraph;
import graphs.Vertex;

import java.util.*;

public class DAGShortestPath {

    public static void main(String[] args) {
        WeightedGraph a = new WeightedGraph("A");
        WeightedGraph b = new WeightedGraph("B");
        WeightedGraph c = new WeightedGraph("C");
        WeightedGraph d = new WeightedGraph("D");
        WeightedGraph e = new WeightedGraph("E");
        WeightedGraph f = new WeightedGraph("F");
        WeightedGraph g = new WeightedGraph("G");
        WeightedGraph h = new WeightedGraph("H");


        a.addNeighbours(b, 4);
        a.addNeighbours(c, 2);

        b.addNeighbours(d, 1);
        c.addNeighbours(d, 2);

        d.addNeighbours(e, 4);



        Map<WeightedGraph, Integer> distance = new HashMap<>();
        distance.put(a, Integer.MAX_VALUE);
        distance.put(b, Integer.MAX_VALUE);
        distance.put(c, Integer.MAX_VALUE);
        distance.put(d, Integer.MAX_VALUE);
        distance.put(e, Integer.MAX_VALUE);
        distance.put(f, Integer.MAX_VALUE);
        distance.put(g, Integer.MAX_VALUE);
        distance.put(h, Integer.MAX_VALUE);


        List<WeightedGraph> visited = new ArrayList<>();
        shortestDag(a, 0, distance, visited);

        System.out.println(visited.toString());
        System.out.println(distance.get(e).toString());

    }

    public static void shortestDag(WeightedGraph v, Integer weight, Map<WeightedGraph, Integer> distance, List<WeightedGraph> visited){
        if (weight < distance.get(v)){
            distance.replace(v, weight);
        }
        
        Set<WeightedGraph> neighbours = v.getNeighbours().keySet();
        for (WeightedGraph n: neighbours){
            shortestDag(n, weight + v.getNeighbours().get(n), distance, visited);
        }

        visited.add(v);
    }
}
