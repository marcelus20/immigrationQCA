package models;

public class Node<T> {
    private Node<T> previous;
    private T element;
    private Node<T> next;

    public static <T> void swapElements(Node<T> node1, Node<T> node2){
        T tempElement = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(tempElement);
    }

    public Node(Node<T> previous, T element, Node<T> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public Node(T element) {
        this.element = element;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
