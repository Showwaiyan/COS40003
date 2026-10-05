//The instance of this class is used to keep track the number of tasks completed
public class TaskCounter {
    private int count;
    public TaskCounter() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void incCount() {
        this.count++;
    }
}
