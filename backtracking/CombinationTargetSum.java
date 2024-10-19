package com.practiseJava.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.

Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.

You may return the combinations in any order and the order of the numbers in each combination can be in any order.
* Input: candidates = [9,2,2,4,6,1,5], target = 8

Output: [
  [1,2,5],
  [2,2,4],
  [2,6]
]

* */
public class CombinationTargetSum {

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[]{9,2,2,4,6,1,5}, 8));
  }
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(new ArrayList<>(), 0, 0, target, candidates, res);
    return res;
  }

  private static void backtrack(List<Integer> curArray, int pos, int sum, int target,
      int[] candidates, List<List<Integer>> res) {
    if (sum == target) {
      res.add(new ArrayList<>(curArray));
    }
    for (int i = pos; i < candidates.length; i++) {
      System.out.println("curArray:" + curArray + "  i: " + i + "  pos: " + pos);
      if (sum + candidates[i] > target) {
        return;
      }
      if (i > pos && candidates[i] == candidates[i - 1]) {
        return;
      }
      curArray.add(candidates[i]);
      backtrack(curArray, i + 1, sum + candidates[i], target, candidates, res);
      curArray.remove(curArray.size() - 1);
    }
  }
}
