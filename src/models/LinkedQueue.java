package models;


import java.util.NoSuchElementException;

/**
 * Class to keep track of the before (before) and after (after) of a doubly link of nodes
 * @param <T>
 */
public class LinkedQueue<T> implements QueueInterface<T>{

    /**
     * Atribute list: before, after, size
     */
    protected Node<T> head;
    protected Node<T> rear;
    protected int size;

    public LinkedQueue() {
        size = 0;
    }

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public T front() {
        return head.getElement();
    }

    @Override
    public T rear() {
        return rear.getElement();
    }


    @Override
    public void enqueue(T element){
        if(isEmpty()) head = rear =  new Node<>(element);
        else{
            Node<T> newRear = new Node<>(element);
            newRear.setPrevious(rear);
            rear.setNext(newRear);
            rear = newRear;
        }
        size++;
    }

    @Override
    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        T toReturn = head.getElement();
        head = head.getNext();
        if(size > 1) head.setPrevious(null);
        else rear = head;
        size--;
        return toReturn;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }
}
