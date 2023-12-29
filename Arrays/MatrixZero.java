package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
* */
public class MatrixZero {
  public static void main(String[] args) {
    MatrixZero spiralMatrix1 = new MatrixZero();
    ArrayList<ArrayList<Integer>> inp = new ArrayList<>();
    inp.add(0, new ArrayList<>(List.of(1,0,1)));
    inp.add(1, new ArrayList<>(List.of(1,1,1)));
    inp.add(2, new ArrayList<>(List.of(1,0,1)));
    System.out.println(spiralMatrix1.matrix(inp));
  }
  public ArrayList<ArrayList<Integer>> matrix(ArrayList<ArrayList<Integer>> a) {
    int m = a.size();
    int n = a.get(0).size();

    boolean row[] = new boolean[a.size()];
    boolean col[] = new boolean[a.get(0).size()];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (a.get(i).get(j) == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] || col[j])
          a.get(i).set(j, 0);
      }
    }
    return a;
  }
}
