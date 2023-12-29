package com.practiseJava.Arrays;

/*
* Find the largest n numbers in an array without sorting the array in one iteration of the array
Example: findLargest([3, 5, 1, 2, 8, 9, 20], 3) => [20, 9, 8]
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNInArray {
  public static void main(String args[]) {
    LargestNInArray largestNInArray = new LargestNInArray();
    ArrayList<Integer> lis = new ArrayList<>(List.of(3, 5, 1, 2, 8, 9, 20));
    System.out.println(largestNInArray.findLargest(lis, 3));
  }

  public ArrayList<Integer> findLargest(ArrayList<Integer> input, int k) {
    ArrayList<Integer> array1 = new ArrayList<>(input);

    PriorityQueue<Integer> res = new PriorityQueue<>();
    for(int i = 0 ; i < input.size(); i++) {
      res.add(input.get(i));
      if(res.size() > k) {
        res.poll();
      }
    }

    ArrayList<Integer> topKList = new ArrayList<>(res);

    return topKList;
  }
}
