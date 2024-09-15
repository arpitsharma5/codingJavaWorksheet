package com.practiseJava.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
* Function to find the maximum sequence of continuous 1's by replacing
*  at most `k` zeros by 1 using sliding window technique
* */
public class ZeroFlipped {
  public static void main(String[] args) {
    ZeroFlipped zeroFlipped = new ZeroFlipped();
    ArrayList<Integer> inp = new ArrayList<>(List.of(1, 0, 0, 1, 0, 1, 0, 1, 0, 1));
    zeroFlipped.getArray(inp, 2);
  }
  public void getArray(ArrayList<Integer> A, int k) {
    int left = 0;   // represents the current window's starting index
    int count = 0;  // stores the total number of zeros in the current window
    int window = 0; // stores the maximum number of continuous 1's found
    // so far (including `k` zeros)

    // store left index of max window found so far
    int leftIndex = 0;

    // maintain a window `[left…right]` containing at most `k` zeros
    for (int right = 0; right < A.size(); right++)
    {
      // if the current element is 0, increase the count of zeros in the
      // current window by 1
      if (A.get(right) == 0) {
        count++;
      }

      // the window becomes unstable if the total number of zeros in it becomes
      // more than `k`
      while (count > k)
      {
        // if we have found zero, decrement the number of zeros in the
        // current window by 1
        if (A.get(left) == 0) {
          count--;
        }

        // remove elements from the window's left side till the window
        // becomes stable again
        left++;
      }

      // when we reach here, window `[left…right]` contains at most
      // `k` zeros, and we update max window size and leftmost index
      // of the window
      if (right - left + 1 > window)
      {
        window = right - left + 1;
        leftIndex = left;
      }
    }

    // no sequence found
    if (window == 0) {
      return;
    }
    System.out.println("The longest sequence has length " + window +
        " from index " + leftIndex + " to " + (leftIndex + window - 1));

    ArrayList<Integer> res = new ArrayList<>();
    for(int i = 0; i < window; i++) {
      if(A.get(leftIndex+i) == 0) {
        res.add(leftIndex+i);
      }
    }
    System.out.println(res);
  }
}
