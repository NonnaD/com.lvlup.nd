package graphs.topological;

import graphs.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalBacktracing {

    public static void main(String[] args) {
        Vertex one = new Vertex("1");
        Vertex two = new Vertex("2");
        Vertex three = new Vertex("3");
        Vertex four = new Vertex("4");
        Vertex five = new Vertex("5");
        Vertex six = new Vertex("6");
        Vertex seven = new Vertex("7");


       one.addNeighbour(two, three);
       two.addNeighbour(five, six);
       three.addNeighbour(four, seven);
       four.addNeighbour(five);
       seven.addNeighbour(five);
       six.addNeighbour(five);


        List<Vertex> graph = new ArrayList<>();
        graph.add(one);   graph.add(two);
        graph.add(three);   graph.add(four);
        graph.add(five);



        System.out.println(graph.toString());

        List<Vertex> ordered = new ArrayList<>();
        topologicalBacktrackingUtil(graph, ordered);

        //we can avoid this reverse if start adding to the ordered from end
        Collections.reverse(ordered);

        System.out.println(ordered.toString());

    }

    //Purpouse of this function is to make sure all vertecies in the graph been visited
    public static void topologicalBacktrackingUtil(List<Vertex> graph, List<Vertex> ordered){

        while (ordered.size() < graph.size()){
            for (Vertex v: graph) {
                if (!ordered.contains(v)) {
                    topologicalBacktracking(v, ordered);
                }
            }
        }
    }

    //This function will work if we provide first vertex as an entry point
    //but we dont know which one is the first or maybe graph is not connected
    //thats why we need to use topologicalBacktrackingUtil()
    public static void topologicalBacktracking(Vertex v, List<Vertex> ordered){
        if (v.getNeighbours().size() <= 0) {
            ordered.add(v);
            return;
        }

        for (Vertex n: v.getNeighbours()){
            if (!ordered.contains(n)){
                topologicalBacktracking(n, ordered);
            }
        }

        //here where backtracking happens
        //on descending phase of recursion function
        //once function exits above for loop it means all it's neighbours are visited and added to
        //at this step we can add current vertex - if all neighbours are visited it means we can exclude them from the search
        ordered.add(v);
    }
}
