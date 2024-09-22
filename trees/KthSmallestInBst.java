package com.practiseJava.trees;

import java.util.Stack;

/*
*
* Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

A binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
Example 1:
Input: root = [2,1,3], k = 1

Output: 1

*/
public class KthSmallestInBst {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(5);
    tree.left = new TreeNode(3);
    tree.right = new TreeNode(8);
    tree.left.left = new TreeNode(1);
    tree.left.right = new TreeNode(4);
    System.out.println(kthSmallest(tree, 2));
  }
  public static int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      k--;
      if (k == 0) {
        return curr.val;
      }
      curr = curr.right;
    }

    return -1;
  }
}
