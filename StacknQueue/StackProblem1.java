package com.practiseJava.StacknQueue;

import java.util.Stack;
/*
* Given a string A, containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
* Note:  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
* */

public class StackProblem1 {
  public static void main(String args[]) {
    StackProblem1 stackProblem1 = new StackProblem1();
    System.out.println(stackProblem1.isValid("])"));
  }

  public int isValid(String str) {
    Stack<Character> stack = new Stack();
    char[] cha = str.toCharArray();
    int value = 1;
    for(int i = 0; i < cha.length ; i++) {
      if(cha[i] == '(' || cha[i] == '{' || cha[i] == '[') {
        stack.push(cha[i]);
      } else {
        if(stack.isEmpty()) {
          return 0;
        }
        if (cha[i] == ')') {
          if(!stack.empty() && stack.pop() != '(') {
            return 0;
          }
        } else if (cha[i] == '}' ) {
          if(!stack.empty() && stack.pop() != '{') {
            return 0;
          }
        } else if (cha[i] == ']') {
          if(!stack.empty() && stack.pop() != '[') {
            return 0;
          }
        }
      }

    }

    return value;
  }
}
