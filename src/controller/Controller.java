package controller;

import static models.Utils.*;


import models.*;
import view.Menu;

import java.sql.Date;
import java.util.IllegalFormatConversionException;
import java.util.List;
import java.util.NoSuchElementException;

public class Controller {

    SystemQ queue;
    Menu menu;

    private static Controller controller;

    public static Controller init(SystemQ queue){
        if(controller == null) controller = new Controller(queue);
        return controller;
    }

    private Controller(SystemQ queue) {
        this.queue = queue;
        this.menu = new Menu();
        while (true){

            showMenu();
        }
    }

    private void showMenu() {
        String option;
        for (int i = 0; i < menu.getOptions().size(); i++) {
            System.out.println(i+1+". "+menu.getOptions().get(i));
        }
        option = input("Choose an option", menu.getOptions().size()+"|[1-9]");

        switch (option){
            case "1":
                enqueuePerson();
                break;
            case "2":
                dequeuePerson();
                break;
            case "3":
                updateInfo();
                break;
            case "4":
                deleteByIndex();
                break;
            case "5":
                searchPerson();
                break;
            case "6":
                deleteById();
                break;
            case "7":
                DeleteNLast();
                break;
            case "8":
                seeFirst();
                break;
            case "9":
                seeLast();
                break;
            case "10":
                seeWholeQueue();
                break;
            default: break;
        }
    }

    private void updateInfo() {
        try{
            System.out.println("Update person info");
            Person person = queue.getSpecificPerson(input("Type the id of the person to change data"));
            Person updated = Person.personFactory(
                    person.getId(),
                    input("Type the new name of this person", "[A-Za-z]+"),
                    input("Type the last name of this person","[A-Za-z]+"),
                    person.getDateOfArrival(),
                    input("Enter passport number"),
                    Priority.valueOf(input("person's priority", Priority.low, Priority.medium, Priority.high))
            );

            if(!updated.equals(person)){
                System.out.println("Updated successfuly");
                queue.set(person.getId(), updated);
                if(updated.getPriority()!= person.getPriority()){
                    System.out.println("Priority has changed, therefore this person will be rearranged in the queue");
                    queue.delete(person);
                    queue.add(updated);
                }
            }
            else System.out.println("Nothing changed");

        }catch (NoSuchElementException e){
            System.out.println("person with this id not found");
        }
        Utils.pause();
    }

    private void searchPerson() {
        System.out.println("Search person by the ID");
        int index = queue.search(input("Enter the id of the person"));
        if (index < 0){
            System.out.println("Person not found");
        }else{
            System.out.println("This person is at the index of" + index + "in the queue");
        }
        pause();
    }

    private void seeWholeQueue() {
        System.out.println("Printing the whole queue");
        Node<Person> current = queue.getHead();
        int sequence = 1;
        System.out.println("\t\t\t\t\tID \t\t\tName \tSurname \tDate \tPassport \tPriority");
        System.out.println();
        while (current != null){
            System.out.println(sequence + " - "+current.getElement().toString());
            current = current.getNext();
            sequence++;
            System.out.println();
        }
        pause();
    }

    private void seeLast() {
        System.out.println("Checking the last of the queue");
        System.out.println(queue.rear());
        pause();
    }

    private void seeFirst() {
        System.out.println("Checking the first (next person) of the queue");
        System.out.println(queue.front());
        pause();
    }

    private void DeleteNLast() {
        System.out.println("Delete the N last in queue");
        try{
            List<Person> personList = queue.delete(Integer.parseInt(input("Enter number of people to remove from the rear","[0-9]+")));
            System.out.println("Deleted successfully these people: ");
            personList.forEach(person -> System.out.println(person));
            pause();
        }catch (NoSuchElementException e){
            System.out.println("Number provided is bigger than queue size...");
        }catch (IllegalFormatConversionException e1){
            e1.printStackTrace();
        }catch (IndexOutOfBoundsException e2){
            System.out.println("Number provided is bigger than queue size...");
        }
    }

    private void deleteById() {
        System.out.println("Delete someone by their id");
        try{
            Person p = queue.delete(input("Enter id of the person to delete"));
            System.out.println("One match found. Deleting...");
            System.out.println("Person details deleted:");
            System.out.println(p);
            pause();
        }catch (NoSuchElementException e){
            System.out.println("Person not found...");
        }
    }

    private void deleteByIndex() {
        System.out.println("Delete someone by index");
        System.out.println("Delete someone by their index position in queue");
        try{
            Person p = queue.deleteByPosition(Integer
                    .parseInt(input("Enter index of the person to delete", "[0-9]+")));
            System.out.println("One match found. Deleting...");
            System.out.println("Person details deleted:");
            System.out.println(p);
            pause();
        }catch (NoSuchElementException e){
            System.out.println("Person not found...");
        }
    }

    private void dequeuePerson() {
        System.out.println("Dequeue a person");
        System.out.println("dequeuing...");
        try{
            Person person = queue.dequeue();
            System.out.println("Dequeued successfully");
            System.out.println("Person dequeued:");
            System.out.println(person);
            pause();
        }catch (NoSuchElementException e){
            System.out.println("There was nothing to dequeue... queue is empty");
            pause();
        }
    }

    private void enqueuePerson() {
        System.out.println("Enqueue a person");
        String name = input("person's name");
        String surname = input("person's last name");
        Date dateOfArrival = new Date(System.currentTimeMillis());
        String passportNumber = input("person's passport");
        Priority priority = Priority.valueOf(input("person's priority", Priority.low, Priority.medium, Priority.high));
        Person person = Person.personFactory(name, surname, dateOfArrival, passportNumber, priority);
        queue.add(person);
        System.out.println("Person enqueued successfully");
        System.out.println("Persons enqueued:");
        System.out.println(person);
        pause();
    }

}
