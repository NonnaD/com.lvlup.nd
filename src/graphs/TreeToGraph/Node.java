package graphs.TreeToGraph;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value){
        this.add(value);
    }

    public void add(int value) {
        if(this.value == 0) this.value = value;
        if (value > this.value) {
            if (rightChild == null) this.rightChild = new Node(value);
            this.rightChild.add(value);
        }

        if (value < this.value){
            if (this.leftChild == null) this.leftChild = new Node(value);
            this.leftChild.add(value);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
