package com.cos40003.lab4_task;

public class CountdownTimer implements Runnable{
   private String name;
   private int seconds;

   public CountdownTimer(String name, int seconds) {
      if (seconds < 0) {
         throw new IllegalArgumentException("Countdown time must be a non-negative value.");
      }
      this.name = name;
      this.seconds = seconds;
   }

   @Override
   public void run() {
      System.out.println(name + " : Starts to countdown from " + seconds);
      while (seconds > 0) {
         System.out.println(name + " : " + seconds + " seconds");
         try {
            Thread.sleep(1000); // Sleep for 1 second
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
         seconds--;
      }
      System.out.println(name + " : Countdown complete!");
   }
}
