package graphs.TreeToGraph;

public class Tree {
   private Node head;
   private int value;

    public Tree(int value) {
        this.add(value);
    }

    public void add(int value){
        if(head == null)this.head = new Node(value);
        this.head.add(value);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
