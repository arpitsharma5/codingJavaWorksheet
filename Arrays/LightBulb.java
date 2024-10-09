package com.practiseJava.Arrays;

import java.util.ArrayList;
import java.util.List;
/*
* There is a corridor in a Jail which is N units long.
*  Given an array A of size N. The ith index of this array is 0 if the light at ith position is faulty otherwise it is 1.

All the lights are of specific power B which if is placed at position X, it can light the corridor from [ X-B+1, X+B-1].

Initially all lights are off.

Return the minimum number of lights to be turned ON to light the whole corridor or -1 if the whole corridor cannot be lighted.
* */
public class LightBulb {
  public static void main(String[] args) {
    LightBulb lightBulb = new LightBulb();
    ArrayList<Integer> inp = new ArrayList<>(List.of(1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0));
    System.out.println(lightBulb.solve(inp, 3));
  }
  public int solve(ArrayList<Integer> A, int B) {
    int count = 0;
    for(int i=0; i< A.size();){
      int right = Math.min(i - 1 + B, A.size() - 1);
      while(right >=0 && A.get(right) == 0){
        right--;
      }
      if(right < 0){
        return -1;
      }
      count++;
      i = right + B ;
    }
    return count;
  }
}
