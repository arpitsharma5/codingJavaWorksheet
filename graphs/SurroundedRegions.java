package com.practiseJava.graphs;
/*
* You are given a 2-D matrix board containing 'X' and 'O' characters.

If a continous, four-directionally connected group of 'O's is surrounded by 'X's, it is considered to be surrounded.

Change all surrounded regions of 'O's to 'X's and do so in-place by modifying the input board.
* Input: board = [
  ["X","X","X","X"],
  ["X","O","O","X"],
  ["X","O","O","X"],
  ["X","X","X","O"]
]

Output: [
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","O"]
]
*/
public class SurroundedRegions {

  public static void main(String[] args) {
    char[][] m = {
        { 'X', 'X', 'X', 'X' },
        { 'X', 'O', 'O', 'X' },
        { 'X', 'O', 'O', 'X' },
        { 'X', 'X', 'X', 'O' },
    };
    var o = solve(m);
    System.out.println(o);
  }
  private static char[][] solve(char[][] board) {
    int ROWS = board.length;
    if (ROWS == 0) return new char[][]{};
    int COLS = board[0].length;

    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        if (board[r][c] == 'O' && (r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1)) {
          capture(board, r, c);
        }
      }
    }

    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X';
        }
      }
    }

    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        if (board[r][c] == 'T') {
          board[r][c] = 'O';
        }
      }
    }
    return board;
  }

  private static void capture(char[][] board, int r, int c) {
    int ROWS = board.length;
    int COLS = board[0].length;

    if (r < 0 || c < 0 || r == ROWS || c == COLS || board[r][c] != 'O') {
      return;
    }
    board[r][c] = 'T';
    capture(board, r + 1, c);
    capture(board, r - 1, c);
    capture(board, r, c + 1);
    capture(board, r, c - 1);
  }
}
