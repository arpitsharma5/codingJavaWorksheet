package com.practiseJava.pointers;

/*
* Input: X[] = [4, 8, 0, 0, 2, 0, 1, 0], Output: X[] = [4, 8, 2, 1, 0, 0, 0, 0]
* */
public class MoveZerosAtEndOfArray {

  public static void main(String[] args) {
    moveZeroes(new int[]{4, 8, 0, 0, 2, 0, 1, 0});
  }

  private static void moveZeroes(int[] arr) {
    int j=0;
    for(int i= 0; i < arr.length; i++) {
      if(arr[i] != 0) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        j++;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " "); // Print the array
    }
  }
}
