package models;

import java.util.List;

/**
 * Because Immigration is implict for people, T will be or extend Person class
 */
public interface ImmigrationQueue <T extends Person>{

    /**
     * • At any time, the staff member should have the ability to see what position in the queue a person is,
     * by typing in a unique ID number that is given to the person when they register in the system. Keep
     * in mind that the ID does not necessarily correspond to the position of the person in the queue.
     * @param id
     * @return
     */
    public int search(String id);

    public int search(T person);


    /**
     * At any time, the staff member should have the ability to delete a person from the system by entering
     * in their unique ID number.
     * @param person
     * @return
     */
    public Person delete (T person);

    public Person delete(String id);

    /**
     * • A method should exist to cut off the after N number of records from the queue. If the staff member
     * types in 3. Then the after 3 objects on the linked list should be removed.
     * @param n
     * @return
     */
    public List<Person> delete (int n);

    /**
     * Delete by a given position
     * @param position
     */
    public Person deleteByPosition(int position);



    public void add(T person);
}
