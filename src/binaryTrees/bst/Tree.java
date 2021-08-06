package binaryTrees.bst;

public class Tree {
    private Node root;
    private int[] treeNodes;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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
    }

    private Node deleteNode(Node root, int val){
        if (root == null){
            System.out.println("Node with given value does not exist");
            return root;
        }
        if (val > root.getData()) {
            //IMPORTANT! this statement will be executed for parent nodes but never for the node we want to delete
            root.setRightChild(deleteNode(root.getRightChild(), val));
        }else if (val < root.getData()){
            //IMPORTANT! this statement will be executed for parent nodes but never for the node we want to delete
            root.setLeftChild(deleteNode(root.getLeftChild(), val));
            //IMPORTANT! this statement will be execute only when - we find node that we want to delete
        }else if (root.getData() == val){
            if (root.getRightChild() == null && root.getLeftChild() == null){
                //this null value will be sent back to it's parent and depend on which side node was located
                //parent node -> child = null
                return null;
            }
            else if (root.getRightChild() == null || root.getLeftChild() == null){
                //this will handle case when node we want to delete has one of the children
                Node single = root.getRightChild() == null ? root.getLeftChild() : root.getRightChild();
                return single;
            }

            //case 3: Node has both children
            //We are not going to actually rewire our node, just replace the value of node we want to delete
            //with value of successor (min value in right child)
            else {
                //successor - find the smallest element in the right subtree of my node
                int smallestInRightSubtree  = root.successor();
                //i reassign data in the node i want to delete with smallest element in its right subtree
                root.setData(smallestInRightSubtree);
                //last step is delete successor from the tree
                //IMPORTANT:
                root.setRightChild(deleteNode(root.getRightChild(), root.getData()));
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
            return lastRight.getData();
        } else return node.successor();
        }
        return -1;
    }
}
