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
        option = input("Choose an option", "[1-"+String.valueOf(menu.getOptions().size())+"]");

        switch (option){
            case "1":
                enqueuePerson();
                break;
            case "2":
                DequeuePerson();
                break;
            case "3":
                searchPerson();
                break;
            case "4":
                deleteById();
                break;
            case "5":
                DeleteNLast();
                break;
            case "6":
                seeFirst();
                break;
            case "7":
                seeLast();
                break;
            case "8":
                seeWholeQueue();
                break;
            default: break;
        }
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

//    private void DeleteByIndex() {
//        System.out.println("Delete someone by index");
//        System.out.println("Delete someone by their index position in queue");
//        try{
//            Person p = queue.delete(input("Enter index of the person to delete"));
//            System.out.println("One match found. Deleting...");
//            System.out.println("Person details deleted:");
//            System.out.println(p);
//            pause();
//        }catch (NoSuchElementException e){
//            System.out.println("Person not found...");
//        }
//    }

    private void DequeuePerson() {
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
