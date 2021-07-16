package binaryTrees;

public class Tree {
    private Node root;
    private int[] treeNodes;

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }else{
           root.insert(value);
        }
    }

    public void traverseInOrder(){
        this.root.traverseInOrder();
    }

    public Node get(int value){
        if(root != null){
           return root.get(value);
        }
        return null;
    }

    public int getMin(){
        return this.root.getMin();
    }

    public int getMax(){
        return this.root.getMax();
    }

    //TODO: Fix delete function
    //logic is not correct
    public void delete(int value){
        Node node = get(value);
        if (node.getLeftChild() == null){
            node = null;
            return;
        }
        if (node.getLeftChild() != null){
            Node leftChildNode = node.getLeftChild();
            node = leftChildNode;
            leftChildNode = null;
        }
    }

}
