package models;

import java.util.Objects;

/**
 * This class is a node that stores a reference to the next node and
 * previous node. It is the doubly link list based node.
 * @param <T>
 */
public class Node<T>{

    /**
     * List of attributes
     */

    private final Node nextNode;
    private final T element;
    private final Node previousNode;


    /**
     * Factory for the node.
     * @param element
     * @param <T>
     * @return
     */
    public static <T> Node <T> nodeFactory(T element){
        return new Node(element);
    }

    /**
     * Complete factory
     * @param nextNode
     * @param previousNode
     * @param element
     * @param <T>
     * @return
     */
    public static <T> Node <T> nodeFactory(Node<T> previousNode, T element, Node<T> nextNode){
        return new Node(previousNode, element, nextNode);
    }

    /**
     * Factory that takes a node element
     * @param node
     * @param <T>
     * @return
     */
    public static <T> Node <T> nodeFactory(Node<T> node){
        return new Node(node);
    }


    /**
     * Constructor 1
     * @param nextNode
     * @param previousNode
     * @param element
     */
    private Node(Node<T> previousNode, T element, Node<T> nextNode) {
        this.previousNode = previousNode;
        this.element = element;
        this.nextNode = nextNode;
    }


    /**
     * Constructor 2
     * @param element
     */
    private Node(T element) {
        this.previousNode = null;
        this.element = element;
        this.nextNode = null;
    }

    /**
     * Constructor 3
     * @param node
     */
    private Node (Node<T> node){
        previousNode = node.getPreviousNode();
        element = (T) node.getElement();
        nextNode = node.getNextNode();
    }


    /**
     * getters
     * @return
     */
    public Node getNextNode() {
        return nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public T getElement() {
        return element;
    }


    /**
     * Immutable setters.
     *
     * Because attributes are final, in order to change the state of this object you will create a new one stead with
     * the changed state.
     *
     * This avoids side effects of changing something you were not suppose to and improves functional programming by
     * the use pure functions.
     *
     *
     */

    public Node <T> withNextNode(Node<T> newNextNode){
        return new Node(previousNode, element, newNextNode);
    }

    public Node <T> withPreviousNode(Node<T> newPreviousNode){
        return new Node(newPreviousNode, element, nextNode);
    }

    public Node <T> withElement(T newElement){
        return new Node<>(previousNode, newElement, nextNode);
    }


    /**
     * Overriding equals and hashcode
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(nextNode, node.nextNode) &&
                Objects.equals(previousNode, node.previousNode) &&
                Objects.equals(element, node.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nextNode, previousNode, element);
    }


    @Override
    public String toString() {
        try{
            return "Node [" +
                    "previous: " + previousNode.getElement() + "," +
                    "element: " + element + "," +
                    " next: " + nextNode.getElement() + "," +
                    "]";
        }catch (NullPointerException e){
            if(nextNode == null && previousNode == null){
                return "Node [" +
                        "previous: none, "  +
                        "element: " + element + "," +
                        " next: none"  +
                        "]";
            }else if(nextNode == null){
                return "(Node:::[" +
                        "previous: "  +previousNode +
                        "element: " + element + "," +
                        " next: none" +
                        "]";
            }else if (previousNode == null){
                return "Node [" +
                        "previous: none " +
                        "element: " + element + "," +
                        " next: " + nextNode.getElement() +
                        "])";
            }else{
                return null;
            }
        }

    }
}
