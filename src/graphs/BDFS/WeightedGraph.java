package graphs.BDFS;

import graphs.Vertex;

import java.util.*;

public class WeightedGraph {

        private String value;
        private Map<WeightedGraph, Integer> neighbours;
        private boolean isVisited;

        public WeightedGraph(String value) {
            this.value = value;
            this.neighbours = new HashMap<>();
        }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<WeightedGraph, Integer> getNeighbours() {
        return neighbours;
    }

    public void addNeighbours(WeightedGraph w, Integer weight) {
        neighbours.put(w, weight);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String toString(){
            return this.getValue();
    }

}
