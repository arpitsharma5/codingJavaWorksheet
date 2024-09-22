package com.practiseJava.trees;

/*
* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
* */
public class ValidSubTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(26);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(3);
    root.left = new TreeNode(10);
    root.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(30);
    root.left.right = new TreeNode(6);

    TreeNode root2 = new TreeNode(10);
    root2.right = new TreeNode(6);
    root2.left = new TreeNode(4);
    root2.left.right = new TreeNode(30);
    System.out.println(isSubtree(root, root2));
  }
  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) {
      return true;
    }
    if (root == null) {
      return false;
    }

    if (sameTree(root, subRoot)) {
      return true;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public static boolean sameTree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root != null && subRoot != null && root.val == subRoot.val) {
      return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
    return false;
  }

}
