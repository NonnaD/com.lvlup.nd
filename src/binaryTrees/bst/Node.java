package binaryTrees.bst;

public class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        //Restrict duplicates
        if (data == value) {
            return;
        }

        //If value less than our node value - insert to the left child
        if (value < data) {
            if (leftChild == null) {
                leftChild = new Node(value);
            } else {
                leftChild.insert(value);
            }
        }
        //If value gather than our node value - insert to the right child
        if (value > data) {
            if (rightChild == null) {
                rightChild = new Node(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    //Depth first - In order traversal -> left side -> root -> right side
    public void inOrderTraverse() {
        if (leftChild != null) {
            leftChild.inOrderTraverse();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.inOrderTraverse();
        }
    }

    //Depth first - Pre order traversal -> root -> left side -> right side
    public void preOrderTraverse() {
        System.out.print(data + ", ");
        if (leftChild != null) {
            leftChild.preOrderTraverse();
        }
        if (rightChild != null) {
            rightChild.preOrderTraverse();
        }
    }

    //Depth first - Post order traversal ->  left side -> right side -> root
    public void postOrderTraverse() {
        if (leftChild != null) leftChild.postOrderTraverse();
        if (rightChild != null) rightChild.postOrderTraverse();
        System.out.print(data + ", ");
    }

    //Breadth first - Level order traversal ->  left side -> right side -> root
    public void levelOrderTraverse() {

    }

    public int getMin() {
        if (leftChild != null) {
            return leftChild.getMin();
        } else {
            return data;
        }
    }

    public int getMax() {
        if (rightChild != null) {
            return rightChild.getMax();
        } else {
            return data;
        }
    }

    public Node get(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }

    /**
     *  -> If subtree does not have left child - first right ancestor will be the successor
     *  We traverse tree and look for the last right turn. Which is first right ancestor for given node
     */
    //TODO: Think of backtracking
    public Node getLastRight(int value, Node lastRight) {
        if (value == this.data) {
            return lastRight;
        }
        if (value < this.data) {
            if (leftChild != null) {
                lastRight = this;
                return leftChild.getLastRight(value, lastRight);
            }
        } else {
            if (rightChild != null) {
                return rightChild.getLastRight(value, lastRight);
            }
        }
        return lastRight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(int data) {
         this.leftChild.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Successor -> next largest element
     *
     *      1. The minimum value in right subtree is successor
     * Minimum value in right subtree can be found:
     * -> If right subtree of given node has left child - the last left child is the minimum
     * -> If right subtree of given node does not have left child - first right ancestor will be the successor
     */
    public int successor() {
        int val = this.data;
        // Minimum value in right subtree can be found:
        // If right subtree has left child - the last left child is the minimum
        if (this.rightChild != null) {
            if (this.rightChild.leftChild != null
                    && downLastLeft(this.rightChild.leftChild).getData() != val) {
                return downLastLeft(this.rightChild.leftChild).getData();
            }
            return rightChild.getData();
        }
        return -1;
    }

    public Node downLastLeft(Node node) {
        if (node.leftChild == null) return node;
        return downLastLeft(node.leftChild);
    }
}

