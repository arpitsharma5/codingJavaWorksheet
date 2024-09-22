package com.practiseJava.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each other.

A queen in a chessboard can attack horizontally, vertically, and diagonally.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.' indicates an empty space.

You may return the answer in any order.
* Input: n = 4

Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

* */
public class NQueensProblem {

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }
  public static List<List<String>> solveNQueens(int n) {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    backtrack(0, n, col, posDiag, negDiag, board, res);
    return res;
  }

  private static void backtrack(int r, int n, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag,
      char[][] board, List<List<String>> res) {
    if (r == n) {
      List<String> copy = new ArrayList<>();
      for (char[] row : board) {
        copy.add(new String(row));
      }
      res.add(copy);
      return;
    }

    for (int c = 0; c < n; c++) {
      if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
        continue;
      }

      col.add(c);
      posDiag.add(r + c);
      negDiag.add(r - c);
      board[r][c] = 'Q';

      backtrack(r + 1, n, col, posDiag, negDiag, board, res);

      col.remove(c);
      posDiag.remove(r + c);
      negDiag.remove(r - c);
      board[r][c] = '.';
    }
  }
}
