package com.practiseJava.oddEvenCode;

public class GFG {

  // Starting counter
  static int counter = 1;

  static int N = 10;

  // Function to print odd numbers
  public void printOddNumber()
  {
    synchronized (this)
    {
      // Print number till the N
      while (counter < N) {
        System.out.println("odd method called");
        // If count is even then print
        while (counter % 2 == 0) {

          // Exception handle
          try {
            System.out.println(Thread.currentThread().getName() + " waiting ");

            wait();
            System.out.println(Thread.currentThread().getName() + "after wait ");

          }
          catch (
              InterruptedException e) {
            e.printStackTrace();
          }
        }

        // Print the number
        System.out.println(Thread.currentThread().getName() + " " + counter);

        // Increment counter
        counter++;

        // Notify to second thread
        notify();
      }
    }
  }

  // Function to print even numbers
  public void printEvenNumber()
  {
    synchronized (this)
    {
      // Print number till the N
      while (counter < N) {
        System.out.println("even method called");
        // If count is odd then print
        while (counter % 2 == 1) {

          // Exception handle
          try {
            System.out.println(Thread.currentThread().getName() + " waiting ");
            wait();
            System.out.println(Thread.currentThread().getName() + "after wait ");

          }
          catch (
              InterruptedException e) {
            e.printStackTrace();
          }
        }

        // Print the number
        System.out.println(Thread.currentThread().getName() + " " + counter);

        // Increment counter
        counter++;

        // Notify to 2nd thread
        notify();
      }
    }
  }

  // Driver Code
  public static void main(String[] args)
  {

    // Create an object of class
    GFG mt = new GFG();

    // Create thread t1
    Thread t1 = new Thread(new Runnable() {
      public void run()
      {
        mt.printEvenNumber();
      }
    }, "even");

    // Create thread t2
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        mt.printOddNumber();
      }
    }, "odd");

    // Start both threads
    t1.start();
    t2.start();
  }
}
