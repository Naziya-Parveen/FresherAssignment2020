
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import java.util.*;


public class displayUser {
	
	public static int rollasc;
	public ArrayList<User> readFromFile()
	{
		ArrayList<User> object1=null;
		String filename="userdata.txt";
		ArrayList<User> us1 = new ArrayList<User>();
		
		
		try
	    {    
	        // Reading the object from a file 
	        FileInputStream file = new FileInputStream(filename); 
	        ObjectInputStream in = new ObjectInputStream(file); 
	        
	       
	       object1=(ArrayList<User>) in.readObject();
	    	   us1.addAll(object1);     
	    } 
	     catch(EOFException e)
		{
	    	 System.out.println("EOF here");
		}
	    catch(Exception ex) 
	    { 
	        System.out.println("IOException is caught" ); 
	        ex.printStackTrace();
	    } 
		
		nameCompare namec = new nameCompare(1);
		Collections.sort(us1,namec);
		return us1;

	}
	
	public void takeDisplayOptions()
	{
		System.out.println("Enter 1 to sort Based on Name");
		System.out.println("Enter 2 to sort Based on RollNo");
		
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();
		
		System.out.println("Enter 1 to sort in ascending and 2 to sort in descending");
		
		int choice2 = sc.nextInt();
		rollasc=choice2;
		
		switch(choice1)
		{
		case 1 : 
			nameCompare namec = new nameCompare(choice2);
			Collections.sort(addUser.users,namec);
			break;
			
		case 2:
			rollCompare rollc = new rollCompare(choice2);
			Collections.sort(addUser.users,rollc);
			break;
			
			default:
				System.out.println("Enter the Right Choice");
			
		}
		
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.println("----------------------------------------------------------------------------------");
		
		for( User u1 : addUser.users)
		{
			System.out.println(u1.toString());
		}
		
		
		
		
		
	}
}