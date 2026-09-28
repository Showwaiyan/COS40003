package com.cos40003.lab4_task;

public class SequentialCountdown {
   public static void main(String[] args) {
      CountdownTimer timer1 = new CountdownTimer("Timer 1", 5);
      CountdownTimer timer2 = new CountdownTimer("Timer 2",5);
      Thread t1 = new Thread(timer1);
      Thread t2 = new Thread(timer2);
      t1.start();
      t2.start();
   }
}
