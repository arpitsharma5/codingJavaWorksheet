package com.practiseJava.trees;

/*
* Lowest Common Ancestor in Binary Search Tree
Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.

The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.*/
public class LowestCommonAncestor {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5);
    tree.left = new TreeNode(3);
    tree.right = new TreeNode(8);
    tree.left.left = new TreeNode(1);
    tree.left.right = new TreeNode(4);
    tree.left.left.left = new TreeNode(2);
    System.out.println(lowestCommonAncestor(tree, new TreeNode(1), new TreeNode(4)).val);
  }
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (true) {
      if (root.val < p.val && root.val < q.val) {
        root = root.right;
      } else if (root.val > p.val && root.val > q.val) {
        root = root.left;
      } else {
        return root;
      }
    }
  }
}
