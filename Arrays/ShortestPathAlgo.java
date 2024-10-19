package com.practiseJava.Arrays;


/* Java program to find the shortest
 path between a given source cell
 to a destination cell.
Breadth first search approach

 */

import java.util.*;

class ShortestPathAlgo {

  static class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class QueueNode {
    Point point;
    int dist;

    QueueNode(Point point, int dist) {
      this.point = point;
      this.dist = dist;
    }
  }

  static boolean isValid(int row, int col, int maxRow, int maxCol) {
    return (row >= 0) && row < maxRow && col >= 0 && col < maxCol;
  }
  static int getShortestDistance(int[][] matrix, Point src, Point dest) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;

    // check if src and dest cell have 1 for traversing
    if(matrix[src.x][src.y] != 1 && matrix[dest.x][dest.y] != 1) {
      return -1;
    }

    // create a boolean array to check for visited cells
    boolean[][] visited = new boolean[maxRow][maxCol];

    int row[] = {-1, 0, 1, 0};
    int col[] = {0, -1, 0, 1};

    QueueNode start = new QueueNode(src, 0);
    visited[src.x][src.y] = true;
    Queue<QueueNode> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      QueueNode currNode = queue.peek();

      if(currNode.point.x == dest.x && currNode.point.y == dest.y) {
        return currNode.dist;
      }

      queue.remove();
      for(int i=0; i < 4; i++) {
        int nextRow = currNode.point.x + row[i];
        int nextCol = currNode.point.y + col[i];
        if(isValid(nextRow, nextCol, maxRow, maxCol)
            && !visited[nextRow][nextCol]
            && matrix[nextRow][nextCol] == 1) {
          visited[nextRow][nextCol] = true;
          QueueNode queueNode = new QueueNode(new Point(nextRow, nextCol), currNode.dist + 1);
          queue.add(queueNode);
        }
      }
    }
    return -1;
  }

  // Driver Code
  public static void main(String[] args)
  {
    int matrix[][] =
        {{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
         { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
         { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
         { 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 },
         { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
         { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
         { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
         { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
         { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

    Point src = new Point(0,0);
    Point dest = new Point(3,4);

    int dist = getShortestDistance(matrix, src, dest);
    System.out.println(dist);
  }
}

