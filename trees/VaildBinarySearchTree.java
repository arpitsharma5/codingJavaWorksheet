package com.practiseJava.trees;
/*
* Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.

A valid binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
* */
public class VaildBinarySearchTree {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5);
    tree.left = new TreeNode(3);
    tree.right = new TreeNode(8);
    tree.left.left = new TreeNode(1);
    tree.left.right = new TreeNode(4);
    tree.left.left.left = new TreeNode(2);
    System.out.println(isValidBST(tree));
  }

  public static boolean isValidBST(TreeNode root) {
    return valid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  private static boolean valid(TreeNode node, double left, double right) {
    if (node == null) {
      return true;
    }
    if (!(left < node.val && node.val < right)) {
      return false;
    }

    return valid(node.left, left, node.val) && valid(node.right, node.val, right);
  }
}
