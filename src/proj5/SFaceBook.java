package proj5;

/**
 * <p>Title: SFaceBook.java</p>
 *
 * <p>Description: SFaceBook class creates SFaceBook object which contains 
 * array of thePeople each element can be stored Person object. It contains 
 * several methods to modify Person object to be friends or not friends with others.
 * States the friends of the each Person.</p>
 * 
 * @author Thita Charoentham
 */

public class SFaceBook {

	private Person[] thePeople;
	private int count;

	/**
	 * Default constructor 
	 * initialize instance variable
	 */
	public SFaceBook()
	{
		thePeople = new Person[20];
		count = 0;
	}
	
	/**
	 * add method --
	 * creates and stores Person in first available array
	 * @param owner - name of the Person 
	 * @param security - security level
	 */
	public void add(String owner, int security)
	{
		if (count<thePeople.length)
		{
			thePeople[count] = new Person(owner,security);
			count++;
		}
		else
			System.out.println("SFaceBook is full");
	}

	/**
	 * friend method --
	 * checks if both name is not the same person 
	 * then they will be added in each other friends list
	 * @param owner first one's name
	 * @param friend second one's name
	 */
	public void friend (String owner, String friend)	
	{
		if (!owner.equals(friend))
		{	
			Person theOwner = findFriend(owner);
			for(int i=0; i<count; i++)
			{
				if (thePeople[i].getName().equals(friend))
				{
					thePeople[i].addFriend(theOwner);
					theOwner.addFriend(thePeople[i]);	
				}
			}
		}
	}

	/**
	 * unFriend method --
	 * checks if both name is not the same person 
	 * remove both name of the list of friend
	 * @param owner first one's name
	 * @param unFriend second one's name
	 */
	public void unFriend(String owner, String unFriend) 
	{
		if (!owner.equals(unFriend))
		{	
			Person theOwner = findFriend(owner);
			for(int i=0; i<count; i++)
			{
				if (thePeople[i].getName().equals(unFriend))
				{
					thePeople[i].unFriend(theOwner);
					theOwner.unFriend(thePeople[i]);	
				}
			}
		}
	}

	/**
	 * friendStatus method --
	 * checks both are friends
	 * @param owner first person
	 * @param another second person
	 * @return true if they are friends else otherwise
	 */
	public boolean friendStatus(String owner, String another) 
	{
		Person theOwner = findFriend(owner);
		Person target = findFriend(another);
		return theOwner.friendsWith(target);
	}

	/**
	 * getFriend method --
	 * return all name of the target's friends
	 * @param owner the target to be searched
	 * @return String list of friends
	 */
	public String getFriend(String owner) 
	{
		Person theOwner = findFriend(owner);
		if (theOwner.getSecurity() == 0)
			return owner + " is friend with: " + theOwner.getFriends();
		else 
			return "";
	}

	/**
	 * getFriendByLevel method--
	 * if the owner security level is 1 
	 * return all name of the target's friends 
	 * and target's friends of friends 
	 * @param owner the target to be searched
	 * @return String if security#1 display list of target's friends & target's friends of friends
	 */
	public String getFriendByLevel(String owner)
	{
		Person theOwner = findFriend(owner);
		if (theOwner.getSecurity()==1)
			return theOwner.getFriendsByLevel();
		else
			return "";
	}

	/**
	 * findFriend method --
	 * search thePeople array if found return Person object 
	 * @param target name of the Person
	 * @return Person object
	 */
	private Person findFriend (String target)
	{
		Person findtarget = new Person("",0);
		for (int i=0;i<count;i++)
		{
			if (thePeople[i].getName().equals(target))
				findtarget = thePeople[i];
		}
		return findtarget;
	}

	/**
	 * toString method --
	 * states thePeople information 
	 * @return str information of each Person in each element
	 */
	public String toString()
	{
		String str = new String();
		Person theOwner = new Person("",0);

		for (int i=0; i<count; i++)
		{
			theOwner = findFriend(thePeople[i].getName());
			int numfriends = theOwner.getNumOfFriend();

			if (numfriends == 0)
				str += (theOwner.getName() + " is friends with: " + "\n");
			else
				str += (theOwner.getName() + " is frientds with: " + theOwner.getFriends() + "\n");
		}
		return str;
	}



}
