package com.practiseJava.backtracking;
/*
* Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.

For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
* Input:
board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "CAT"

Output: true
* */
public class SearchWord {

  public static void main(String[] args) {
    System.out.println(exist(new char[][]{{'A', 'B', 'C', 'D'}, {'S', 'A', 'A', 'T'}, {'A', 'C', 'A', 'E'}}, "CAT"));
  }

  public static boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(board, word, 0, i, j, m, n)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private static boolean dfs(char[][] board, String word, int index, int i, int j, int m, int n) {
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
      return false;
    }
    if (index == word.length() - 1) {
      return true;
    }

    board[i][j] = '#';

    if (dfs(board, word, index + 1, i - 1, j, m, n)
        || dfs(board, word, index + 1, i + 1, j, m, n)
        || dfs(board, word, index + 1, i, j - 1, m, n)
        || dfs(board, word, index + 1, i, j + 1, m, n)) {
      return true;
    }

    board[i][j] = word.charAt(index);
    return false;
  }
}
