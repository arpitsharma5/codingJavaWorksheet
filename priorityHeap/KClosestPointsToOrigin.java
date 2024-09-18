package com.practiseJava.priorityHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
* ou are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane. You are also given an integer k.

Return the k closest points to the origin (0, 0).

The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).
* Input: points = [[0,2],[2,0],[2,2]], k = 2

Output: [[0,2],[2,0]]*/
public class KClosestPointsToOrigin {
  public static void main(String[] args) {
    int[][] inp = new int[][]{{0,2},{2,0},{2,2}};
    System.out.println(closestPoints(inp, 2));
  }

  private static int[][] closestPoints(int[][] inp, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
    for(int[] point: inp) {
      int dist = point[0]*point[0] + point[1]*point[1];
      pq.add(new int[]{dist, point[0], point[1]});
    }
    int[][] result = new int[k][2];
    for (int i = 0; i < k; ++i) {
      int[] point = pq.poll();
      result[i] = new int[]{point[1], point[2]};
    }
    return result;
  }
}
