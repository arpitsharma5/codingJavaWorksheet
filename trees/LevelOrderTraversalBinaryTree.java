package com.practiseJava.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
* Level Order Traversal of Binary Tree
Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

Example 1:
Input: root = [1,2,3,4,5,6,7]

Output: [[1],[2,3],[4,5,6,7]]
* */
public class LevelOrderTraversalBinaryTree {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5);
    tree.left = new TreeNode(3);
    tree.right = new TreeNode(8);
    tree.left.left = new TreeNode(1);
    tree.left.right = new TreeNode(4);
    tree.left.left.left = new TreeNode(2);
    System.out.println(levelOrder(tree));
  }
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();
    if (root != null) {
      q.add(root);
    }

    while (!q.isEmpty()) {
      List<Integer> val = new ArrayList<>();

      for (int i = 0, len = q.size(); i < len; i++) {
        TreeNode node = q.poll();
        val.add(node.val);
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      res.add(val);
    }
    return res;
  }
}
