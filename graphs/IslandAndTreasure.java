package com.practiseJava.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
* You are given a m*n grid initialized with these three possible values:

-1 - A water cell that can not be traversed.
0 - A treasure chest.
INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
Fill each land cell with the distance to its nearest treasure chest.
* If a land cell cannot reach a treasure chest than the value should remain INF.

Assume the grid can only be traversed up, down, left, or right.
* Input: [
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]

Output: [
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]
*
* below is solved using bfs
* */
public class IslandAndTreasure {

  public static void main(String[] args) {
    int[][] m = {
        {2147483647,-1,0,2147483647},
        {2147483647,2147483647,2147483647,-1},
        {2147483647,-1,2147483647,-1},
        {0,-1,2147483647,2147483647}
    };
    islandsAndTreasure(m);
    System.out.println(m);
  }
  public static void islandsAndTreasure(int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) q.add(new int[] { i, j });
      }
    }
    if (q.size() == 0) return;
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int row = cur[0];
      int col = cur[1];
      for (int[] dir : dirs) {
        int x = row + dir[0];
        int y = col + dir[1];
        if (
            x >= m ||
                y >= n ||
                x < 0 ||
                y < 0 ||
                grid[x][y] != Integer.MAX_VALUE
        ) continue;
        q.add(new int[] { x, y });

        grid[x][y] = grid[row][col] + 1;
      }
    }
  }
}
