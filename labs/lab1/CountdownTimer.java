public class CountdownTimer {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Countdown start ...");
    int n = 5;
    for (int i = n; i > 0; i--) {
      System.out.println("Time remaining: "+i+" seconds"); 
      Thread.sleep(1000);
    }
    System.out.println("Countdown complete!");
  }
}
