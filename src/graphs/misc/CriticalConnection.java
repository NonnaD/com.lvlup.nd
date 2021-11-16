package graphs.misc;

import java.util.*;

public class CriticalConnection {
    public static void main(String[] args) {


    }


    /**
     * Given a network of servers where each server is connected to every other server directly or indirectly through the bidirectional connections in the network, find all the critical connections.
     *
     * A connection in a connected network is said to be critical if removing it disconnects the network.
     *
     * Connection is critical if vertex has single parent
     */

    public static List<List<Integer>> find_critical_connections(
            int number_of_servers, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> parents = new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        //O(n)
        for(int i = 0; i < connections.size(); i++){
            if(!graph.containsKey(connections.get(i).get(0))){
                List<Integer> neigh = new ArrayList<>();
                neigh.add(connections.get(i).get(1));
                graph.put(connections.get(i).get(0),neigh);
            }else{
                graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            }
            if(!graph.containsKey(connections.get(i).get(1))){
                List<Integer> neigh = new ArrayList<>();
                neigh.add(connections.get(i).get(0));
                graph.put(connections.get(i).get(1),neigh);
            }else{
                graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
            }

        }

        //dfs on graph for each vertex preserve in map<vert, numberOfParents>
        int i = connections.get(0).get(0);
        dfs(graph, i, parents, visited);
        for(int c: parents.keySet()){

            ArrayList<Integer> res = new ArrayList<>();
            //if i have a single parent my child should also be my parent
            //if any of my childs is my parent an i already know i have only one parent
            //i can say my child is my only parent
            //creepy
            if(c == 1){
                int parent = -1;
                for (int l: graph.get(c)){
                    if(graph.get(l).contains(c)) parent = l;
                }

                res.add(c);
                res.add(parent);
                output.add(res);
            }
        }

        return output;
    }


    public static void  dfs( Map<Integer, List<Integer>> graph, int v, Map<Integer, Integer> parents, List<Integer> visited){
        visited.add(v);

        for(int n: graph.get(v)){
            if(!parents.containsKey(n)){
                parents.put(n, 1);
            }else{
                parents.replace(n, parents.get(n) + 1); }
            if(!visited.contains(n)){
                dfs(graph,n, parents, visited);
            }
        }
    }
}

