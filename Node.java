public class Node<T> {
    
    public T value;
    public Node<T> rest;

    public Node(T value) {

        this.value = value;
        this.rest = null;

    }
    
    public Node(T value, Node<T> rest) {

        this.value = value;
        this.rest = rest;

    }

}