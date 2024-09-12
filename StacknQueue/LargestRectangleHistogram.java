package com.practiseJava.StacknQueue;

import java.util.Stack;

/*
* Input: heights = [7,1,7,2,2,4]

Output: 8*/
public class LargestRectangleHistogram {

  public static void main(String[] args) {
    int inp[] = {7,1,7,2,2,4};
    System.out.println(calculate(inp));
  }

  private static int calculate(int[] heights) {
    int maxArea = 0;
    Stack<int[]> stack = new Stack<>();
    for(int i=0; i < heights.length; i++) {
      int start = i;
      while(!stack.isEmpty() && heights[i] < stack.peek()[1]) {
        int[] top= stack.pop();
        int index = top[0];
        int height = top[1];
        maxArea = Math.max(maxArea, height * (i - index));
        start = index;
      }
      stack.push(new int[]{start, heights[i]});
    }
    for (int[] pair : stack) {
      int index = pair[0];
      int height = pair[1];
      maxArea = Math.max(maxArea, height * (heights.length - index));
    }
    return maxArea;
  }
}
