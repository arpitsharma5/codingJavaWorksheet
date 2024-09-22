package com.practiseJava.trees;

public class BalancedBinaryTree {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.left.left = new TreeNode(4);
    tree.left.right = new TreeNode(5);
    tree.left.left.left = new TreeNode(8);
    System.out.println(isBalanced(tree));
  }

  public static boolean isBalanced(TreeNode root) {
    return dfs(root)[0] == 1;
  }

  private static int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{1, 0};
    }

    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    boolean balanced = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
    int height = 1 + Math.max(left[1], right[1]);

    return new int[]{balanced ? 1 : 0, height};
  }
}
