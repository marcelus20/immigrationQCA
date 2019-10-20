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
    private Node<T> previousNode;
    private T element;
    private Node<T> nextNode;


    /**
     * Factory for the node.
     * @param element
     * @param <T>
     * @return
     */
    public static <T> Node <T> nodeFactory(T element){
        return new Node<T>(element);
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
        return new Node<T>(node);
    }


    public static <T> Node <T> nodeFactory(){
        return new Node<T>();
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


    private Node(){
        previousNode = null;
        element = null;
        nextNode = null;
    }

    /**
     * Constructor 3
     * @param node
     */
    private Node (Node<T> node){
        previousNode = node.getPreviousNode();
        element = node.getElement();
        nextNode = node.getNextNode();
    }


    public Node <T> addNext(Node<T> node){
        return new Node<>(this, node.getElement(), null);
    }

    public Node <T> addNext(T element){

        return new Node<>(this, element, null);
    }




    /**
     * getters
     * @return
     */
    public Node<T> getNextNode() {
        return nextNode;
    }

    public Node<T> getPreviousNode() {
        return previousNode;
    }

    public T getElement() {
        return element;
    }


    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
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
            return "Node:::[" +
                    "previous: " + previousNode.getElement() + "," +
                    "element: " + element + "," +
                    " next: " + nextNode.getElement() + "," +
                    "]";
        }catch (NullPointerException e){
            if(nextNode == null && previousNode == null){
                return "Node:::[" +
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
                return "Node:::[" +
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
