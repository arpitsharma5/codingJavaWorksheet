package com.practiseJava.graphs;
/*
* Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.

An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
*
* Input: grid = [
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
Output: 4*/
public class CountNumberOfIslands {

  public static void main(String[] args) {
    char[][] m = {
        { '1', '1', '0', '0', '0' },
        { '0', '1', '0', '0', '1' },
        { '0', '0', '0', '1', '1' },
        { '0', '0', '0', '0', '0' },
        { '1', '0', '1', '1', '0' }
    };
    System.out.println(numIslands(m));
  }
  public static int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public static void dfs(char[][] grid, int i, int j) {
    if (
        i < 0 ||
            j < 0 ||
            i >= grid.length ||
            j >= grid[0].length ||
            grid[i][j] == '0'
    ) {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
  }
}
