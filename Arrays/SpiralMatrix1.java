package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;
/*
* Given a matrix of M * N elements (M rows, N columns), return all elements of the matrix in spiral order.
* */
public class SpiralMatrix1 {
  public static void main(String[] args) {
    SpiralMatrix1 spiralMatrix1 = new SpiralMatrix1();
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(List.of(1, 2, 3, 4)));
    A.add(new ArrayList<>(List.of( 5, 6, 7, 8)));
    A.add(new ArrayList<>(List.of(9, 10, 11, 12)));
    A.add(new ArrayList<>(List.of(13, 14, 15, 16)));
    System.out.println(spiralMatrix1.spiralOrder(A));
  }
  public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
    int left = 0;
    int top = 0;
    int depth = 0;
    int rowLength = A.size();
    int colLength = A.get(0).size();
    int dir = 0;
    ArrayList<Integer> res = new ArrayList<>();
    res.add(0, A.get(top).get(left));
    for(int i = 1; i < rowLength * colLength; i++) {
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
      res.add(i, A.get(top).get(left));
    }
    return res;
  }
}
