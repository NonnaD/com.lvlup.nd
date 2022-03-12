package graphs.stronglyconnectedcomponent;

import graphs.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrijansAlgorithm {

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
            Map<Vertex, Integer> discoveryTime = new HashMap<>();
            Map<Vertex, Integer> lowLevel = new HashMap<>();
            dfs_trijan(zero, visited, discoveryTime, lowLevel);

            for (Vertex v: discoveryTime.keySet()){
                System.out.println(v + " : " + discoveryTime.get(v));
            }

            System.out.println();
            for (Vertex v: lowLevel.keySet()){
                System.out.println(v + " : " + lowLevel.get(v));
            }

        }

        public static int discoveryTime = -1;

        /**
         * IMPORTANT! Once upon a time ... in some area 5 Vertices were born and they got connected into graph.
         *
         *               So each vertex should go to all its neighbours
         *               and assigned itself the lowLevel of it's neighbour if it's less then it's own lowLevel
         *               And this new property will be called - LOW LEVEL LINK by default it equals to discovery time
         *               But this assignment should happen on the way back fro dfs so each vertex for sure got the lowest value
         *
         *            1. If discovery time == low level -> vertex is head of SCC strongly connected component
         *            2. If discovery time > low level -> backward edge present
         *            2. If Edge is pointing to a visited node already in stack than  - it's a BACK EDGE
         *            3. If edge is pointing to the visited not which gone from stack - it's a CROSS EDGE
         */
        public static void dfs_trijan(Vertex v, List<Vertex> visited, Map<Vertex,
                Integer> discoveryTimeMap, Map<Vertex, Integer> lowLevel){
            visited.add(v);
            discoveryTime++;
            discoveryTimeMap.put(v, discoveryTime);
            lowLevel.put(v, discoveryTime);
            for (Vertex n: v.getNeighbours()){
                if (!visited.contains(n)){
                    dfs_trijan(n, visited, discoveryTimeMap, lowLevel);
                }
                lowLevel.replace(v, Math.min(lowLevel.get(v), lowLevel.get(n)));

            }
        }
}
