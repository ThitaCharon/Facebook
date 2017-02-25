package proj5;

/**
 * <p>Title: FriendNotFoundException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 */
@SuppressWarnings("serial")

 public class FriendNotFoundException extends RuntimeException{

	 /**
	  * Initializes an FriendNotFoundException storing an appropriate 
	  * message along with the type of the collection (as specified by the user).
	  */
	 public FriendNotFoundException(String collection){

		 super ( collection + " ") ;
	 }

 }
