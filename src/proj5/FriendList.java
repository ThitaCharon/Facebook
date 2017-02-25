package proj5;
/**
 * <p>Title: FriendList.java</p>
 *
 * <p>Description: FriendList class creates a linked Node which first node always be an empty node.
 * FriendList class is using for stores the list of friends. It contains several methods 
 * to modify and return information.  EmptyCollectionException and FriendNotFoundException
 * will be handle in some methods. </p>
 * @author Thita Charoentham
 */
public class FriendList {

	private Node first;
	private int count;
	private Node loopPosition;

	/** FriendList default constructor
	 *  initialize instance variable of first, count, and loopPosition
	 */
	public FriendList()
	{
		first = new Node(null);
		loopPosition = first;
		count = 0;
	}

	/** 
	 * size method --
	 * count how many friends on the list
	 * @return count total number of friends
	 */
	public int size()
	{
		return count;
	}

	/**
	 * isEmpty method --
	 * determines whether or not the list is empty.
	 * @return true if this list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * addToFront method --
	 * add new item at the beginning next to the first node
	 * increment count 
	 * @param newFriend new person to be added
	 */
	public void addToFront(Person newFriend)
	{
		first.setNext(new Node(newFriend,first.getNext()));
		count++;
	}
	
	/**
	 * remove method --
	 * searching all the linked node & specific person to be remove
	 * if found remove and modify the linked, else handle FriendNotFoundException
	 * if the node is empty throw EmptyCollectionException
	 * @throws FriendNotFoundException
	 * @throws EmptyCollectionException
	 * @param searchFriend a target to be removed
	 * @return the node which be removed
	 */
	public Person remove (Person searchFriend) 
	{
		if (isEmpty())
			throw new EmptyCollectionException("No target to be removed!\n");
	
		Node current = first;
		Person target = current.getNext().getPerson();
	
		if (target.getName().equals(searchFriend.getName()))
		{
			first = current.getNext();
			count--;
			return target;
		}
		else
		{
			while(current.getNext() != null)
			{
				target = current.getNext().getPerson();
				if (target.getName().equals(searchFriend.getName()))
				{
					current.setNext(current.getNext().getNext());
					count--;
					return target;
				}
				else
					current = current.getNext();	
			}
			throw new FriendNotFoundException("No target to be removed!\n");
		}
	}
	
	/**
	 * restList method --
	 * reset loopPosition move to the fist node
	 */
	public void resetList()
	{
		loopPosition = first;
	}

	/**
	 * getNextPerson method --
	 * get item from each node move one at a time
	 * fist time get called move to the node next to first node
	 * @return data which stores in the Node
	 */
	public Person getNextPerson ()
	{
		if (loopPosition == first)
			loopPosition = first.getNext();
		else
			loopPosition = loopPosition.getNext();
		return loopPosition.getPerson();
	}

	/**
	 * search method --
	 * searching specific friend  
	 * @param searchFriend the person to be searched
	 * @return true if found in the list, else otherwise 
	 */
	public boolean search (Person searchFriend)
	{
		Person target = null;
		Node current = null;
		if (isEmpty())
			throw new EmptyCollectionException ("The list is empty!\n"); 
		else
		{
			current = first.getNext();
			while(current != null)
			{
				target = current.getPerson();
				if (target.getName().equals(searchFriend.getName()))
					return true;
				current = current.getNext();
			}
			return false;
		}
	}

	/**
	 * listOfFriends method --
	 * return name of all friend in the list
	 * @throw EmptyCollectionException if the node is empty 
	 * @return str name of everyone in the list
	 */
	public String listOfFriends()
	{
		String str = new String();
		Person target = null;
		Node current = null;

		if (isEmpty())
			throw new EmptyCollectionException ("The list is empty!\n");
		else
		{	
			current = first.getNext();
			while(current!= null)
			{
				target = current.getPerson();
				str += target.getName() + " ";
				current = current.getNext();
			}
		}
		return str;
	}
}
