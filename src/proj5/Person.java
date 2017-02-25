package proj5;

/**
 * <p>Title: Person.java</p>
 *
 * <p>Description: Person class creates a Person object with name, securityLevel, and friends
 * as a linked node. Person class has methods to return information of the Person, display 
 * friend list based upon the securityLevel. Modify their friend list, add friend or unFriend,
 * also checking two persons are friends or same person. </p>
 * @author Thita Charoentham
 */

public class Person {
	
	private String name;
	private int securityLevel;
	private FriendList friends;
	
	/**
	 * Parameterize constructor --
	 * initialize instance variable name, securityLevel and friends
	 * @param personName name to be stores in name
	 * @param level security level 1 means public, 0 mean private
	 */
	public Person(String personName, int level)
	{
		name = personName;
		securityLevel = level;
		friends = new FriendList();
	}
	
	/**
	 * getName method --
	 * return name of Person
	 * @return name 
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * getSecurity method --
	 * return security level
	 * @return 1 for public, 0 for private 
	 */
	public int getSecurity() // adding method
	{
		return securityLevel;
	}
	
	/**
	 * addFriend method --
	 * add another person into the list of friends
	 * @param newFriend the person to be added 
	 */
	public void addFriend(Person newFriend)
	{
		friends.addToFront(newFriend); 
	}
	
	/**
	 * unFriend method --
	 * remove particular friend on the list
	 * @param target the person to be removed
	 */
	public void unFriend(Person target)
	{
		friends.remove(target);
	}
	
	/**
	 * friendsWith method --
	 * searching target in the friends list 
	 * @param target the person whom be searched 
	 * @return true if both are friends else otherwise
	 */
	public boolean friendsWith (Person target)
	{
		return friends.search(target);
	}
	
	/**
	 * getFriends method --
	 * return all name of friend in the list of friends
	 * @return name of this Person's friends
	 */
	public String getFriends()
	{
		return friends.listOfFriends();
	}
	
	/**
	 * getFriendsByLevel method --
	 * return all name of friends of this Person and  
	 * this Person's friends of friends
	 * @return name of this Person's friends & Person's friends of friends
	 */
	public String getFriendsByLevel()
	{
		friends.resetList(); //edit
		int num = friends.size();
		String str = new String();
		str += name + " is friend with: " + friends.listOfFriends();
		
		for (int i=0; i< num; i++)
		{
			Person oneOfFriend = friends.getNextPerson();
			str += "and\n" + oneOfFriend.getName() + " is friend with: " + oneOfFriend.getFriends();
		}
		return str;
	}
	
	/**
	 * equals method --
	 * checking is same person
	 * @param target the person to be compared
	 * @return true if same person else otherwise
	 */
	public boolean equals(Person target)
	{
		return name.equals(target.name);
	}
	
	/**
	 * getNumOfFriend method --
	 * return how many of friends this Person has
	 * @return number of friends in the list
	 */
	public int getNumOfFriend() // adding method
	{
		return friends.size();
	}

}
