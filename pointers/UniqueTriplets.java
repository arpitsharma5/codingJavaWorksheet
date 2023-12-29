package com.practiseJava.pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Given an array of integers, find all unique triplets in the array which give the sum of zero.
Example 1:
Input: [-1, 0, 1, 2, -1, -4] Output: [[-1, -1, 2], [-1, 0, 1]]
Example 2:
Input: [0, 0, 0] Output: [[0, 0, 0]]
Example 3:
Input: [-2, 0, 1, 1, 2] Output: [[-2, 0, 2], [-2, 1, 1]]
Example 4:
Input: [1, -1, -1, 0] Output: [[-1, 0, 1]]
Example 5:
Input: [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1] Output: []
Example 6:
Input: [3, 0, -2, -1, 1, 2] Output: [[-2, -1, 3], [-2, 0, 2], [-1, 0, 1]]
*/
public class UniqueTriplets {
  public static void main(String args[]) {
    UniqueTriplets uniqueTriplets = new UniqueTriplets();
    ArrayList<Integer> lis = new ArrayList<>(List.of(-1, 0, 1, 2, -1, -4));
    System.out.println(uniqueTriplets.findLargest(lis));
  }

  public Set<ArrayList<Integer>> findLargest(ArrayList<Integer> list) {
    Set<ArrayList<Integer>> res = new HashSet<>();
    Collections.sort(list);
    int n = list.size();
    for(int i = 0; i < n -1; i++) {
      int l = i+1;
      int r = n-1;
      int x = list.get(i);
      while (l < r) {
        if(x + list.get(l) + list.get(r) == 0) {
          ArrayList<Integer> part = new ArrayList<>();
          part.add(x);
          part.add(list.get(l));
          part.add(list.get(r));
          res.add(part);
          l++;
          r--;
        }
        else if(x + list.get(l) + list.get(r) < 0) {
          l++;
        } else {
          r--;
        }
      }

    }
    return res;
  }
}
