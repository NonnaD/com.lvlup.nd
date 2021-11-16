package graphs.TreeToGraph;

import graphs.Vertex;

import java.util.*;

public class BinaryTreeToGraph {

    public static void main(String[] args) {

        Tree tree = new Tree(25);
        //Visual representation can be found src/binaryTrees/bst/visual/tree.png
        int[] pt = new int[]{20, 15, 27,30,29,26,22,32, 17};
        Arrays.stream(pt).forEach(tree::add);

        //Just to test if tree is constructed correct
        //treeInOrder(tree.getHead());

        Vertex v = new Vertex(String.valueOf(tree.getHead().getValue()));
        treeToGraph(tree.getHead(), v);

        printGraphWithAllNeighbours(v.getNeighbours().get(0));
    }

    public static void treeToGraph(Node tree, Vertex graph){

        if (tree.getLeftChild()!= null) {
            Vertex v = new Vertex(String.valueOf(tree.getLeftChild().getValue()));
            graph.addNeighbour(v);
            v.addNeighbour(graph);
            treeToGraph(tree.getLeftChild(), v);
        }
        if (tree.getRightChild()!= null){
            Vertex v = new Vertex(String.valueOf(tree.getRightChild().getValue()));
            graph.addNeighbour(v);
            v.addNeighbour(graph);
            treeToGraph(tree.getRightChild(), v);
        }
    }

    public static void printGraphWithAllNeighbours(Vertex v){
        System.out.println(v.getValue() + " vertex");
        for (Vertex n: v.getNeighbours()){
            System.out.println(n.getValue() + " neighbour");
        }
    }

}

