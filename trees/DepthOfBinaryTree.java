package com.practiseJava.trees;

public class DepthOfBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    System.out.println(depth(root));
  }

  public static int depth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return 1+ Math.max(depth(root.left), depth(root.right));
  }
}
