package com.practiseJava.pointers;

/*
* You are given an integer array heights where heights[i] represents the height of the ith
*You may choose any two bars to form a container. Return the maximum amount of water a container can store.
* Input: height = [1,7,2,5,4,7,3,6]
Output: 36
* */
public class MaxWaterContainer {

  public static void main(String[] args) {
    int[] inp = {1,7,2,5,4,7,3,6};
    System.out.println(maxWater(inp));
  }

  static int maxWater(int[] inp) {
    int len = inp.length;
    int l = 0, r = len - 1 ;
    int maxArea = Integer.MIN_VALUE;
    while (l < r) {
      int area = Math.min(inp[l], inp[r]) * (r-l) ;
      maxArea = Math.max(area, maxArea);
      if(inp[l] < inp[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }
}
