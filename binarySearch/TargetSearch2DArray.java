package com.practiseJava.binarySearch;
/*You are given an m x n 2-D integer array matrix and an integer target.

Each row in matrix is sorted in non-decreasing order.
The first integer of every row is greater than the last integer of the previous row.
* Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10

Output: true*/
public class TargetSearch2DArray {

  public static void main(String[] args) {
    int matrix[][] = {{1,2,4,8}, {10,11,12,13}, {14,20,30,40}, {42,44,46,48}};
    System.out.println(searchMatrix(matrix, 42));
  }
  public static boolean searchMatrix(int[][] matrix, int target) { // first check in which row and then in column
    int ROWS = matrix.length;
    int COLS = matrix[0].length;

    int top = 0, bot = ROWS - 1;
    while (top <= bot) {
      int midRow = (top + bot) / 2;
      if (target > matrix[midRow][COLS - 1]) {
        top = midRow + 1;
      } else if (target < matrix[midRow][0]) {
        bot = midRow - 1;
      } else {
        break;
      }
    }
    if (!(top <= bot)) {
      return false;
    }
    int row = (top + bot) / 2;
    int l = 0, r = COLS - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (target > matrix[row][m]) {
        l = m + 1;
      } else if (target < matrix[row][m]) {
        r = m - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
