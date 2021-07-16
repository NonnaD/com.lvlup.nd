package binaryTrees;

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

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
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
        }else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
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
