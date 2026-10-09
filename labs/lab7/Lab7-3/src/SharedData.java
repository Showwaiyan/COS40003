public class SharedData {
    private int data;
    public SharedData(int data) {
        this.data = data;
    }
    public void increment() {
        this.data++;
    }
    public void decrement() {
        this.data--;
    }

    public int getData() {
        return this.data;
    }
}
