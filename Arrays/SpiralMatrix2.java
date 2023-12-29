package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;

/*
* Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
* */
public class SpiralMatrix2 {
  public static void main(String[] args) {
    SpiralMatrix2 spiralMatrix1 = new SpiralMatrix2();

    System.out.println(spiralMatrix1.spiralOrder(5));
  }
  public ArrayList<ArrayList<Integer>> spiralOrder(final int A) {
    int left = 0;
    int top = 0;
    int depth = 0;
    int rowLength = A;
    int colLength = A;
    int dir = 0;
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    for(int i = 0; i< A; i++) {
      res.add(i, new ArrayList<>(A));
      for(int j = 0; j < A; j++) {
        res.get(i).add(j, 1);
      }
    }
    res.get(0).set(0, 1);
    for(int i = 2; i <= Math.pow(A, 2); i++) {
      switch (dir) {
        case 0: // right
          if(left == colLength - depth - 1) {
            dir = 1;
            top++;
          } else {
            left++;
          }
          break;
        case 1: // bottom
          if(top == rowLength - depth -1) {
            dir=2;
            left--;
          } else {
            top++;
          }
          break;
        case 2: //left
          if(left == depth) {
            dir= 3;
            top--;
            depth++;
          } else {
            left--;
          }
          break;
        case 3: // top
          if(top == depth) {
            dir = 0;
            left++;
          } else {
            top--;
          }
          break;
      }
      res.get(top).set(left, i);
    }
    return res;
  }
}
