package com.practiseJava.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.

Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. If it's not possible to finish all courses, return an empty array.
*
* Input: numCourses = 3, prerequisites = [[1,0]]

Output: [0,1,2]

* Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]

Output: []
*/
public class CourseSchedule2 {

  public static void main(String[] args) {
    System.out.println(findOrder(3, new int[][]{{0,1}, {1,2} , {2,0}}));
  }
  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> prereq = new HashMap<>();
    for (int[] pair : prerequisites) {
      prereq.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
    }

    List<Integer> output = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    for (int course = 0; course < numCourses; course++) {
      if (!dfs(course, prereq, visit, cycle, output)) {
        return new int[0];
      }
    }

    int[] result = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      result[i] = output.get(i);
    }
    return result;
  }

  private static boolean dfs(int course, Map<Integer, List<Integer>> prereq,
      Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
    if (cycle.contains(course)) {
      return false;
    }
    if (visit.contains(course)) {
      return true;
    }

    cycle.add(course);
    for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
      if (!dfs(pre, prereq, visit, cycle, output)) {
        return false;
      }
    }
    cycle.remove(course);
    visit.add(course);
    output.add(course);
    return true;
  }
}
