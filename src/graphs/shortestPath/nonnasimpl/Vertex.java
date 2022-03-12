package graphs.shortestPath.nonnasimpl;

import java.util.HashMap;
import java.util.Map;

public class Vertex{
    String value;
    boolean isVisited;
    int distance;
    Vertex predecessor;
    Map<Vertex, Integer> neighbours;

    public Vertex(String value) {
        this.value = value;
        this.distance = Integer.MAX_VALUE;
        this.neighbours = new HashMap<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public Map<Vertex, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Vertex n, Integer weight) {
       this.neighbours.put(n,weight);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
