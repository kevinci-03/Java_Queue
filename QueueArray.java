public class QueueArray {

    /*Implements an efficient first-in first-out Abstract Data Type using a Java array */

    private int capacity;
    private int num_items = 0;
    private int front = 0;
    private int rear = 0;
    private int[] items;

    public QueueArray(int capacity) {

        this.capacity = capacity;
        items = new int[this.capacity];

    }

    public boolean isEmpty() {  // Time Complexity: O(1)

        return this.num_items == 0;

    }

    public boolean isFull() {  // // Time Complexity: O(1)

        return this.num_items == this.capacity;

    }

    public void enqueue(int item) {  // Time Complexity: O(1)

        if (this.isFull()) {
            throw new IndexOutOfBoundsException("Queue OverFlow");
        }
        this.items[rear] = item;
        this.rear = (this.rear + 1) % this.capacity;
        this.num_items++;

    }

    public int dequeue() {  // Time Complexity: O(1)

        if(this.isEmpty()) {
            throw new IndexOutOfBoundsException("Queue UnderFlow");
        }
        int item = this.items[front];
        this.front = (this.front + 1) % this.capacity;
        this.num_items--;
        return item;

    }

    public int size() {  // Time Complexity: O(1)

        return this.num_items;

    }

}