package com.practiseJava.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.

The pair [0, 1], indicates that must take course 1 before taking course 0.

There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.

Return true if it is possible to finish all courses, otherwise return false.
Example 1:
Input: N = 4, P = 3,  array[] = {{1,0},{2,1},{3,2}}
Output: Yes
Explanation: It is possible to finish all the tasks in the order : 3 2 1 0.
First, we will finish task 3. Then we will finish task 2, task 1, and task 0.

Example 2:
Input: N = 4, P = 4,  array[] = {{1,2},{4,3},{2,4},{4,1}}
Output: No
Explanation: It is impossible to finish all the tasks. Let’s analyze the pairs:
For pair {1, 2} -> we need to finish task 1 first and then task 2. (order : 1 2).
For pair{4, 3} -> we need to finish task 4 first and then task 3. (order: 4 3).
For pair {2, 4} -> we need to finish task 2 first and then task 4. (order: 1 2 4 3).
But for pair {4, 1} -> we need to finish task 4 first and then task 1 but this pair contradicts the previous pair. So, it is not possible to finish all the tasks.
*/
public class CourseSchedule1 {

  public static void main(String[] args) {
    System.out.println(canFinish(4, new int[][]{{1,0},{2,1},{3,2}}));
  }
  public static boolean canFinish(int n, int[][] prerequisites) {
    List<Integer>[] adj = new List[n];
    int[] indegree = new int[n];
    List<Integer> ans = new ArrayList<>();

    for (int[] pair : prerequisites) {
      int course = pair[0];
      int prerequisite = pair[1];
      if (adj[prerequisite] == null) {
        adj[prerequisite] = new ArrayList<>();
      }
      adj[prerequisite].add(course);
      indegree[course]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();
      ans.add(current);

      if (adj[current] != null) {
        for (int next : adj[current]) {
          indegree[next]--;
          if (indegree[next] == 0) {
            queue.offer(next);
          }
        }
      }
    }

    return ans.size() == n;
  }
}
