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

      // we start observing from left to right in the array
      // Find the left most possible place which can be li by the light at position i
      // siminarly find he rightmost place which can be lit by light at this place i
      int left = i+1-B  <  0?0 : i+1-B;
      int right = i-1+B > A.size()-1 ? A.size()-1 : i-1+B;


      // we are greedily trying to find the right-most position possible where a light
      // can be activated such that the position i can also be lit.
      // rightmost guarantees the optimal value proved by greedy approach.
      while(right >=0 && right >= i-B+1 && A.get(right) == 0){
        right--;
      }


      // if we find no light which can light the current position we return -1.
      if(right < 0 || right < i-B+1){
        return -1;
      }

      // indicates we have allocated a light.
      count++;

      // After the position at 'right' is lit, we don't necessarily need to check from
      // 'right+1', instead we can directly hop to 'B' places after this position
      // because once light is lit at one place the nex 'B-1' places will
      // atuomatically be lit.
      i += (right + B  - i);
    }
    return count;
  }
}
