// This example shows how to create and use thread by using Runnable interface,
// which is more flexible compare to extend from Thread class as Java only
// allows single inheritance
package com.cos40003.lab4_2;

public class ConcurrencyProblem implements Runnable {
  static int classData = 0;
  int instanceData = 0;

  public void run() {
    int localData = 0;

    while (localData < 1000000) {
      localData++;
      instanceData++;
      classData++;
    }
    System.out.println("thread: " + Thread.currentThread().getId() +
                       "\tlocalData: " + localData + "\tinstanceData: " +
                       instanceData + "\tclassData: " + classData);
  }

  public static void main(String[] args) {

    ConcurrencyProblem instance1 = new ConcurrencyProblem();
    ConcurrencyProblem instance2 = new ConcurrencyProblem();

    Thread t1 = new Thread(instance1);
    Thread t2 = new Thread(instance2);

    t1.start();
    t2.start();
  }
}

// Notice and understand why the value of classData, instanceData & localData
// are not the same
// Notice also the difference between
// 1. running two threads of the same object (instance)
// 2. running two threads of different objects (instances)
// localData (store in stack memory) are not shared among the threads, however
// the instanceData (heap memory) and
// classData (some permanent memory space) are shared by the threads
