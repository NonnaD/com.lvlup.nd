package binaryTrees.bst;

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

    public void inOrderTraverse(){
        if (root != null)
            this.root.inOrderTraverse();

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
        //toBeDeleted holds the reference (pointer) of the object we want to delete
        //I can modify properties of the node for which toBeDeleted holds the reference
        //but if i set toBeDeleted=null it will reassign toBeDeleted to null
        //But the node object will not change
        Node toBeDeleted =  deleteNode(this.root, value);

        //so here to be deleted should hold reference
        // to the parent of the node we want to deleted
        //in this case i can change it's child property which is our node
        //and set it to null
        //it will unlink the node from it's parent - no more reference - GC will come after it

        //And toBeDeleted does not make sense it's actually toBeDeletedParent

    }

    private Node deleteNode(Node root, int val){
        if (root == null){
            System.out.println("Node with given value does not exist");
            return root;
        }
        if (val > root.getData()) {
            System.out.println("rc " + root.getRightChild().getData());
            root = deleteNode(root.getRightChild(), val);
        }else if (val < root.getData()){
            System.out.println("lc " + root.getLeftChild().getData()) ;
           root = deleteNode(root.getLeftChild(), val);
        }else if (root.getData() == val){
            //for leaf node - node with 0 children
            if (root.getRightChild() == null){
                return root;
            }

        }
        return root;
    }

    /**
     * Successor -> next largest element
     *
     *      1. The minimum value in right subtree is successor
     * Minimum value in right subtree can be found:
     * -> If subtree has left child - the last left child is the minimum
     * -> If subtree does not have left child - first right ancestor will be the successor
     */
    public int successor(int val){
        if(root != null){
        Node node = get(val);
        Node lastRight = root.getLastRight(val, new Node(-1));
        if (node.successor() == -1){
            System.out.println(lastRight.getData() + " ddd");
            return lastRight.getData();
        } else return node.successor();
        }
        return -1;
    }
}
