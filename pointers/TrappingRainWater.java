package com.practiseJava.pointers;

/*You are given an array non-negative integers heights which represent an elevation map. Each value heights[i] represents the height of a bar, which has a width of 1.

Return the maximum area of water that can be trapped between the bars.
Input: height = [0,2,0,3,1,0,1,3,2,1]
Output: 9
* */
public class TrappingRainWater {

  public static void main(String[] args) {
    int inp[] = {0,2,0,3,1,0,1,3,2,1};
    System.out.println(trapWater(inp));
  }

  private static int trapWater(int[] inp) {
    int res = 0;
    int l=0, r= inp.length -1;
    int lMax = inp[l];
    int rMax = inp[r];
    while (l < r) {
      if(lMax < rMax) {
        l++;
        lMax = Math.max(lMax, inp[l]);
        res += lMax - inp[l];
      } else {
        r--;
        rMax = Math.max(rMax, inp[r]);
        res += rMax - inp[r];
      }
    }
    return res;
  }
}
