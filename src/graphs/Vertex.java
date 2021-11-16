package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private String value;
    private List<Vertex> neighbours;
    //I used List<Vertex> visited instead of this value
    private boolean isVisited;

    public Vertex(String value) {
        this.value = value;
        this.neighbours = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Vertex neib) {
        neighbours.add(neib);
    }

    public void addNeighbour(Vertex ...neibs){
        neighbours.addAll(Arrays.asList(neibs));
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
