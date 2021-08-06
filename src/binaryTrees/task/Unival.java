package binaryTrees.task;

import binaryTrees.bst.Node;
import binaryTrees.bst.Tree;

import java.util.Arrays;

public class Unival {

    public static void main(String[] args) {
        int[] pt = new int[]{5,5,5,5,5,4,5};

        Tree tree = new Tree();
        Arrays.stream(pt).forEach(tree::insert);

        System.out.println(findSingleValueTrees(tree.getRoot()));
    }



    static int findSingleValueTrees(Node root){
        int[] arr = new int[1];
        if(root != null)  unival(root, root.getData(), arr);
        return arr[0];

    }

    private static boolean unival(Node root, int base, int[] sum){
        if (root.getData() != base){
               sum[0]++;
               return false;
        }

        boolean isUniRigth = true;
        boolean isUniLeft = true;
        if(root.getLeftChild() != null){
            isUniRigth = unival(root.getLeftChild(), base, sum);
        }
        if(root.getRightChild() != null){
            isUniLeft = unival(root.getRightChild(), base, sum);
        }
        //sum[0]+= isUniLeft&&isUniRigth?0:1;
        if (!isUniLeft&&isUniRigth){
            sum[0]++;
        }
       return isUniLeft&&isUniRigth;
    }
}
