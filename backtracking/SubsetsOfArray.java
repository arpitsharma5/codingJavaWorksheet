package com.practiseJava.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* Given an array A[] of positive integers, print all the unique non-empty subsets of the array
* Input: nums = [1,2,3]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class SubsetsOfArray {

  public static void main(String[] args) {
    System.out.println(subsets(new int[]{1,1,3}));
  }
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    dfs(nums, 0, subset, res);
    return res;
  }

  private static void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> res) {
    res.add(new ArrayList<>(subset));
    for(int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      dfs(nums, i+1, subset, res);
      subset.remove(subset.size()-1);
    }
  }
}
