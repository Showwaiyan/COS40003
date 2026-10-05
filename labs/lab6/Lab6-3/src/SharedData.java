
public class SharedData {
    private int data;

    public SharedData(int data) {
        this.data = data;
    }

    public int readData() {
        return this.data;
    }

    public void writeData(int newData) {
        this.data = newData;
    }
}
