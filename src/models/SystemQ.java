package models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SystemQ extends LinkedQueue<Person> implements ImmigrationQueue{


    public SystemQ() {

    }

    @Override
    public int search(String id) {
        Node<Person> tempNode = head;
        int index = 0;
        while (tempNode.getNext() != null){
            if(id.equals(tempNode.getElement().getId())) return index;
            index++;
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    @Override
    public int search(Person person) {
        Node<Person> tempNode = head;
        int index = 0;
        while (tempNode.getNext() != null){
            if(person.getId().equals(tempNode.getElement().getId())) return index;
            index++;
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    @Override
    public Person delete(Person person) {
        Node<Person> tempNode = head;
        while (tempNode.getNext() != null){
            if(person.getId().equals(tempNode.getElement().getId())){
                size--;
                return tempNode.getElement();
            }
            tempNode = tempNode.getNext();
        }
        throw new NoSuchElementException();
    }

    @Override
    public Person delete(String id) {
        Node<Person> tempNode = head;
        while (tempNode.getNext() != null){
            if(id.equals(tempNode.getElement().getId())){
                size--;
                return tempNode.getElement();
            }
            tempNode = tempNode.getNext();
        }
        throw new NoSuchElementException();
    }

    @Override
    public List<Person> delete(int n) {
        List<Person> personList = new ArrayList<>();
        int counter = 0;
        if(n <= size){
            while (counter < n){
                personList.add(rear.getElement());
                rear = rear.getPrevious();
                rear.setNext(null);
                counter++;
                if(!isEmpty()) size--;
            }
        }
        return personList;
    }
    @Override
    public void add(Person person){
        super.enqueue(person);
        Node<Person> tempNode = rear;
        while (tempNode.getPrevious() != null){
            if(tempNode.getPrevious().getElement().getPriority().getPrecedence()
                    > person.getPriority().getPrecedence()){

                Node.swapElements(tempNode.getPrevious(), tempNode);
            }
            tempNode = tempNode.getPrevious();
        }

    }
}
