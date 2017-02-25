package proj5;

/**
 * <p>Title: Node Class</p>
 *
 * <p>Description: Defines a node class capable of storing a 
 * reference to a Person object and a reference to the next node in
 * a linked list. Accessors and mutators are defined for both.</p>
 *
 * @author Thita Charoentham
 */

public class Node {

	private Person data;
	private Node next;

	/**
	 * parameterized constructor - initializes data to the user 
	 * specified value; next is set to null
	 * @param newPerson the value to be stored in the node
	 */
	public Node (Person newPerson)
	{
		data = newPerson;
		next = null;
	}

	/**
	 * parameterized constructor - initializes data and next to user 
	 * specified values
	 * @param newPerson the object reference to be stored in the node
	 * @param nextPerson the reference to the next node in the list
	 */
	public Node (Person newPerson, Node nextPerson)
	{
		data = newPerson;
		next = nextPerson;
	}

	/**
	 * setPerson - stores a new value in data
	 * @param newPerson the object reference to be stored in the node
	 */
	public void setPerson(Person newPerson)
	{
		data = newPerson;
	}

	/**
	 * setNext - stores a new value in next
	 * @param nextPerson the reference to be stored in next
	 */
	public void setNext(Node nextPerson)
	{
		next = nextPerson;
	}

	/**
	 * getPerson - returns the reference stored in data
	 * @return a reference to the data stored in the node
	 */
	public Person getPerson()
	{
		return data;
	}

	/**
	 * getNext - returns the reference stored in next
	 * @return the reference stored in next
	 */
	public Node getNext()
	{
		return next;
	}
}
