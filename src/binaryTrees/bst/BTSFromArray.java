package binaryTrees.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTSFromArray {
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        build(node.left = new TreeNode(), node.right = new TreeNode());
//
//        System.out.println(node.left.val);
//        System.out.println(node.right.val);


        TreeNode root;

    }

    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    List<List<Integer>> allPaths = new ArrayList();
    List<Integer> path = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        bfs(root, targetSum, 0);
        return allPaths;
    }

    public void  bfs(TreeNode root, int targetSum, int depth){
            if(root == null) return;
            path.add(root.val);
            depth+=root.val;
            if(root.left == null && root.right == null){
                if(targetSum == depth) allPaths.add(new ArrayList(path));
                path.remove(path.size() - 1);
                return;}

            bfs(root.left, targetSum, depth);
            bfs(root.right, targetSum, depth);
            path.remove(path.size() - 1);

        }
        


    public static void build(TreeNode left, TreeNode right){
        left.val = 2;
        right.val = 3;
    }

}



 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode parent;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
