package models;


import java.util.NoSuchElementException;

/**
 * Class to keep track of the front (front) and rear (rear) of a doubly link of nodes
 * @param <T>
 */
public class LinkedQueue<T> implements QueueInterface<T>{

    /**
     * Atribute list: front, rear, size
     */
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
        size = 0;
    }

    /**
     * getters
     * @return
     */
    public Node<T> getFront() {
        return front;
    }

    public Node<T> getRear() {
        return rear;
    }


    /**
     * keep track of the size. Complexity is O(1)
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * check whether queue is empty by looking at size and value of the front attribute
     * Complexit O(3)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size <= 0 && front == null;
    }

    /**
     *
     * @return
     */
    @Override
    public T front() {
        return front.getElement();
    }

    @Override
    public T rear() {
        return rear.getElement();
    }


    /**
     * adds a next node to the current rear, making it a new rear
     * @param element
     */
    @Override
    public void enqueue(T element) {
        if(isEmpty()){
            enqueueWhenFrontIsNull(element);
        }else if(front.getNextNode() == null){
            enqueueWhenFrontNextNodeIsNull(element);
        }else{
            Node<T> last = rear;
            rear = Node.nodeFactory(element);
            rear.setPreviousNode(last);
            last.setNextNode(rear);
        }
        size++;
    }

    /**
     * Helper for enqueue. Responsability - enqueue when front.getNextNode() is null
     * @param element
     */
    private void enqueueWhenFrontNextNodeIsNull(T element) {
        Node<T> newNode = Node.nodeFactory(element);
        newNode.setPreviousNode(front);
        front.setNextNode(newNode);
        rear = newNode;
    }

    /**
     * Helper for enqueue. Responsability - enqueue when front is null
     * @param element
     */
    private void enqueueWhenFrontIsNull(T element) {
        front = Node.nodeFactory(element);
        rear = front;
    }


    /**
     * Updates the front of the queue to front.getNextNode() and gets rid of the old front.
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()){//there is not element to return
            throw new NoSuchElementException();
        }else if(front.getNextNode() != null){
            size--;
            return dequeueWhenFrontNextNodeNotNull();
        }else{
            size--;
            return dequeueWhenFrontNextNodeIsNull();
        }
    }

    /**
     * Helper for dequeue. Responsability - dequeue when front.getNextNode() is null
     * @return
     */
    private T dequeueWhenFrontNextNodeIsNull() {
        T item = front.getElement();
        front = null;
        return item;
    }

    /**
     * Helper for dequeue. Responsability - dequeue when front.getNextNode() is not null
     * @return
     */

    private T dequeueWhenFrontNextNodeNotNull() {
        T item = front.getElement();
        front = front.getNextNode();
        front.setPreviousNode(null);
        return item;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "front=" + front.getElement() +
//                ", rear=" + rear.getElement() +
                '}';
    }
}
