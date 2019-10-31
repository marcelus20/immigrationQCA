package models;

public interface QueueInterface<T> {

    /*
     * This method should return the number o elements
     * in the queue
     */
    public int size();

    /*
     * This method should return true is there is no elements
     * in the queue, and false if there is at least one element
     * in the queue
     */
    public boolean isEmpty();

    /*
     * This method should return the object at the top
     * of the queue. If the queue is empty it should return
     * null
     */
    public T front();

    /*
     * This method should return the object at the after
     * of the queue. If the queue is empty it should return
     * null
     */
    public T rear();

    /*
     * This method should add the element to the after of the
     * queue
     */
    public void enqueue (T element);

    /*
     * This method should return the object at the top
     * of the queue and remove if from it.
     * If the queue is empty it should return
     * null
     */
    public T dequeue();
}
