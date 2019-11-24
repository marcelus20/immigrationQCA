package models;


import java.sql.Date;
import java.util.Objects;

/**
 *  Person blueprint
 */
public class Person {

    /**
     * List of attributes
     */
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Date dateOfArrival;
    private final String passportNumber;
    private final Priority priority;


    /**
     * Factory 1 - list of params follows constructor 1 params
     * @param id
     * @param firstName
     * @param lastName
     * @param dateOfArrival
     * @param passportNumber
     * @param priority
     * @return
     */
    public static Person personFactory(String id, String firstName, String lastName, Date dateOfArrival, String passportNumber, Priority priority){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }


    /**
     * Factory 2 - param list follows constructor 2 params
     * @param firstName
     * @param lastName
     * @param dateOfArrival
     * @param passportNumber
     * @param priority
     * @return
     */
    public static Person personFactory(String firstName, String lastName, Date dateOfArrival, String passportNumber, Priority priority){
        return new Person(firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    /**
     * Factory 3
     * @param person
     * @return
     */
    public static Person personFactory(Person person){
        return new Person(person);
    }


    /**
     * Static method for generating an ID of size 20 "person id"
     * @return
     */
    public static String generatesPersonId(){
        return Utils.generateId(20);
    }


    /**
     * Constructor 1 - complete params list
     * @param id
     * @param firstName
     * @param lastName
     * @param dateOfArrival
     * @param passportNumber
     * @param priority
     */
    private Person(String id, String firstName, String lastName, Date dateOfArrival, String passportNumber, Priority priority) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfArrival = dateOfArrival;
        this.passportNumber = passportNumber;
        this.priority = priority;
    }

    /**
     * Constructor 2 - without the id param
     * @param firstName
     * @param lastName
     * @param dateOfArrival
     * @param passportNumber
     * @param priority
     */
    private Person(String firstName, String lastName, Date dateOfArrival, String passportNumber, Priority priority) {
        this.id = generatesPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfArrival = dateOfArrival;
        this.passportNumber = passportNumber;
        this.priority = priority;
    }


    /**
     * Constructor 3
     * @param person
     */
    private Person(Person person){
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.dateOfArrival = person.getDateOfArrival();
        this.passportNumber = person.getPassportNumber();
        this.priority = person.getPriority();
    }


    /**
     * Getters
     * @return
     */
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public Priority getPriority() {
        return priority;
    }


    /**
     * Immutable setters - final properties cannot be changed, therefore a new object with the
     * different state is returned instead.
     */

    public Person withId(String id){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    public Person withFirstName(String firstName){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    public Person withLastName(String lastName){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    public Person withDateOfArrival(Date dateOfArrival){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    public Person withPassPortNumber(String passportNumber){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }

    public Person withPriority(Priority priority){
        return new Person(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }


    /**
     * Equals and Hashcode
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(dateOfArrival, person.dateOfArrival) &&
                Objects.equals(passportNumber, person.passportNumber) &&
                priority == person.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfArrival, passportNumber, priority);
    }


    @Override
    public String toString() {
        return
                "\t" + id +
                "\t" + firstName +
                "\t" + lastName +
                "\t" + dateOfArrival +
                "\t" + passportNumber +
                "\t" + priority;
    }
}
