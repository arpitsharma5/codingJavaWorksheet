package com.practiseJava.graphs;

import java.util.HashSet;
import java.util.Set;

/*You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).

An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.

The area of an island is defined as the number of cells within the island.

Return the maximum area of an island in grid. If no island exists, return 0.
Input: grid = [
  [0,1,1,0,1],
  [1,0,1,0,1],
  [0,1,1,0,1],
  [0,1,0,0,1]
]

Output: 6
* */
public class MaxAreaOfIsland {

  public static void main(String[] args) {
    int[][] m = {
        {0,1,1,0,1},
        {1,0,1,0,1},
        {0,1,1,0,1},
        {0,1,0,0,1}
    };
    System.out.println(maxAreaOfIsland(m));
  }
  public static int maxAreaOfIsland(int[][] grid) {
    int ROWS = grid.length;
    int COLS = grid[0].length;
    Set<String> visit = new HashSet<>();

    int area = 0;
    for (int r = 0; r < ROWS; r++) {
      for (int c = 0; c < COLS; c++) {
        area = Math.max(area, dfs(grid, visit, r, c));
      }
    }
    return area;
  }

  private static int dfs(int[][] grid, Set<String> visit, int r, int c) {
    int ROWS = grid.length;
    int COLS = grid[0].length;

    if (r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == 0 || visit.contains(r + "," + c)) {
      return 0;
    }
    visit.add(r + "," + c);
    return 1 + dfs(grid, visit, r + 1, c) + dfs(grid, visit, r - 1, c) + dfs(grid, visit, r, c + 1) + dfs(grid, visit, r, c - 1);
  }
}
