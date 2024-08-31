package com.practiseJava.linkedlist;

public class FindDuplicate {
  public static void main(String []args) {
    int arr[] = {1,3,4,2,2};
    int arr1[] = {3,1,3,4,2};
    System.out.println(findDuplicate(arr1));
  }
  public static int findDuplicate(int[] nums) {
    int slow = 0, fast = 0;
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    slow = 0;
    //3.Find repeating element
    while(slow != fast){
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
}
