public class QueueNodeList<T> {

    Node<T> rear;
    Node<T> front;
    int num_items;

    public QueueNodeList() {

        this.rear = null;
        this.front = null;
        this.num_items = 0;

    }

    public boolean isEmpty() {

        return this.num_items == 0;

    }

    public void enqueue(T item) {

        this.rear = new Node<T>(item, this.rear);
        this.num_items++;

    }

    public T dequeue() {

        T front = null;
        if (this.front == null && this.rear == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            if (this.front == null) {
                while (this.rear != null) {
                    T rear = this.rear.value;
                    this.rear = this.rear.rest;
                    this.front = new Node<>(rear, this.front);
                }
            }
            if (this.front != null) {
                front = this.front.value;
                this.front = this.front.rest;
                this.num_items--;
            }
        return front;
        }

    }

    public int size() {

        return this.num_items;

    }

}