package com.practiseJava.StacknQueue;

import java.util.Stack;

/*
* You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.

Return the integer that represents the evaluation of the expression.

The operands may be integers or the results of other operations.
The operators include '+', '-', '*', and '/'.
Assume that division between integers always truncates toward zero.
*
* Input: tokens = ["1","2","+","3","*","4","-"]

Output: 5

Explanation: ((1 + 2) * 3) - 4 = 5
* */
public class EvaluateReversePolishNotation {

  public static void main(String[] args) {
    String inp[] = {"1","2","+","3","*","4","-"};
    System.out.println(evaluate(inp));
  }

  private static int evaluate(String[] inp) {
    Stack<Integer> stack = new Stack<>();
    for(var token: inp) {
      if(token.equalsIgnoreCase("+")) {
        stack.push(stack.pop()+stack.pop());
      } else if(token.equalsIgnoreCase("-")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b - a);
      } else if (token.equalsIgnoreCase("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (token.equalsIgnoreCase("/")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push((int) ((double) b / a));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }
}
