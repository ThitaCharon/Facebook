package proj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <p>Title: Proj5App.java</p>
 *
 * <p>Description: This application is written for testing FriendList class,
 * Person class, and SFaceBook class. Using Scanner read data from file 
 * facebookData and create SFaceBook which is contained in Person object, 
 * and each Person contain FriendList object. Using try-catch block throws 
 * FileNotFoundException if file can't be found. Display each transaction 
 * 'P'# create Person in SFaceBook, 'F'# makes two people befriends, 
 * 'U'# unFriend two people, 'Q'# are they friends, 'V'# display friend list
 * based upon security level, 'X'# close file. Throw FriendNotFoundException
 * if the name is not found. </p>
 * 
 * @author Thita Charoentham
 */

public class Proj5App {

	public static void main(String[] args) throws FileNotFoundException {

		try{
			Scanner fileScan = new Scanner(new File("facebookData.txt"));
			SFaceBook facebook = new SFaceBook();
			while (fileScan.hasNext())
			{
				try{
					char doesST = fileScan.next().charAt(0);
					if (doesST == 'P')	
					{
						String name = fileScan.next();
						int security = fileScan.nextInt();
						System.out.println(doesST + " " + name+ " " + security);
						facebook.add(name,security);
						System.out.println(facebook.toString());
					}
					else if (doesST == 'F')
					{
						String friend = fileScan.next();
						String addFriend = fileScan.next();
						System.out.println(doesST + " " + friend + " " + addFriend);
						facebook.friend(friend, addFriend);
						System.out.println(facebook.toString());
					}
					else if (doesST == 'U')
					{
						String owner = fileScan.next();
						String unFriend = fileScan.next();
						System.out.println(doesST + " " + owner + " " + unFriend);
						facebook.unFriend(owner,unFriend);
						System.out.println(facebook.toString());
					}
					else if (doesST == 'Q') 
					{
						String owner = fileScan.next();
						String another = fileScan.next();
						System.out.println(doesST + " " + owner + " " + another);
						try
						{
							boolean areFriend = facebook.friendStatus(owner,another);
							if (areFriend == true)
								System.out.println(owner + " and " + another + " are friends\n");
							else
								System.out.println(owner + " and " + another + " are not friends\n");
						}
						catch(EmptyCollectionException ex)
						{
							System.out.println("EmptyCollectionException: " + ex.getMessage());
						}

					}
					else if (doesST == 'V')
					{
						String owner = fileScan.next();
						System.out.println(doesST + " " + owner);
						try
						{
							System.out.println(facebook.getFriendByLevel(owner) + facebook.getFriend(owner) + "\n");
						}
						catch(EmptyCollectionException ex)
						{
							System.out.println("EmptyCollectionException: " + ex.getMessage());
						}
					}
					else if (doesST == 'x')
					{
						fileScan.close();
					}	
				}
				catch(FriendNotFoundException ex)
				{
					System.out.println("FriendNotFoundException: " + ex.getMessage());
				}
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("FileNotFoundException: " + ex.getMessage());
		}
	}

	/**
	 * testing part
	 * 
	 * 
	 */
	/**

	FriendList list = new FriendList();
	Person NC = new Person("Nancy" , 1);
	Person TC = new Person("thita" , 1);

	System.out.println("Call listOfFriend method on the empty list:");
	try{	//call empty list

		System.out.println("\nnow contains: " + list.listOfFriends());
	}
	catch(EmptyCollectionException ex)
	{
		System.out.println("EmptyCollectionException: " + ex.getMessage());
	}

	System.out.println("size is " + list.size() + "\nIs Empty: " + list.isEmpty() + "\nnow contains: ");

	// call search on empty list
	System.out.println("\nCall search method on the empty list:");
	try{

		System.out.println(list.search(eNan));
	}
	catch(EmptyCollectionException ex)
	{
		System.out.println("EmptyCollectionException: " + ex.getMessage());
	}
	// testing add and search method
	list.addToFront(eNan);

	System.out.println("\nAdd 1 friend Nancy now \nsize is " + list.size() + "\nIs Empty: " + list.isEmpty() +
			"\nnow contains: " + list.listOfFriends() + "\n");

	list.addToFront(eLek);
	System.out.println("\nAdd another friend Lekki \nnow size is " + list.size() + "\nIs Empty: " + list.isEmpty() +
			"\nnow contains: " + list.listOfFriends() + "\n");

	System.out.println("Search for Lekki: " + list.search(eLek));
	System.out.println("Search for Nancy: " + list.search(eNan) + "\n");


	//Person myFriend = list.getNextPerson();
	//System.out.println(myFriend);

	FriendList list2 = new FriendList();
	Person f1 = new Person("Nancy" , 1);
	Person f2 = new Person("Lekki" , 1);
	Person f3 = new Person("Mee" , 1);
	Person f4 = new Person("Jee" , 1);
	Person f5 = new Person("Jee" , 1);
	Person f0 = new Person("NoBody", 0);
	Person myFriend;

	list2.addToFront(f1);
	list2.addToFront(f2);
	list2.addToFront(f3);
	list2.addToFront(f4);
	System.out.println("\nAdd friends\nNow contain: " + list2.listOfFriends() + "\nsize: " + list2.size() + "\n");

	list2.resetList();

	System.out.println("Call getNext method:");
	myFriend = list2.getNextPerson();
	System.out.println(myFriend.getName());
	myFriend = list2.getNextPerson();
	System.out.println(myFriend.getName());
	myFriend = list2.getNextPerson();
	System.out.println(myFriend.getName());
	myFriend = list2.getNextPerson();
	System.out.println(myFriend.getName());

	Person removePer = list2.remove(f4);
	System.out.println("\nWho will be removed: " + removePer.getName());
	System.out.println("\nNow contain: " + list2.listOfFriends() + "\nsize: " + list2.size() + "\n");

	try{
		removePer = list2.remove(f0);
	}
	catch(FriendNotFoundException ex)
	{
		System.out.println("FriendNotFoundException: " + ex.getMessage());
	}

	System.out.println("Is Nancy same person as Jee: " + f1.equals(f4));
	System.out.println("Is Jee same person Jee: " + f5.equals(f4));
	System.out.println("\n\n\n");*/
}
