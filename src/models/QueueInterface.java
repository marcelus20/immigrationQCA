package models;

public interface QueueInterface<E> {

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
    public E front();

    /*
     * This method should return the object at the rear
     * of the queue. If the queue is empty it should return
     * null
     */
    public E rear();

    /*
     * This method should add the element to the rear of the
     * queue
     */
    public void enqueue(E element);

    /*
     * This method should return the object at the top
     * of the queue and remove if from it.
     * If the queue is empty it should return
     * null
     */
    public E dequeue();
}
