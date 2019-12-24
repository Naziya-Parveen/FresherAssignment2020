
import java.util.*;
import java.io.*;


public class addUser {

	public static ArrayList<User> users ;
	
	public addUser()
	{
		displayUser disp = new displayUser();
		this.users=disp.readFromFile();

		
	}
	public void AddUser()
	{
		Scanner sc = new Scanner(System.in);
		
		String name , address;
		int age,rollno;
		String subj[] = new String[6];
		int max_sub=6;
		
		System.out.println("enter name");
		name=sc.next();
		System.out.println("enter roll no");
		rollno=sc.nextInt();
		System.out.println("enter age");
		age = sc.nextInt();
		System.out.println("enter address");
		address = sc.next();
		
		int count=0;
		while(count<max_sub)
		{
			System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
			String st = sc.next();
			if(st.equals("y")|| st.equals("Y"))
			{
				
				subj[count]=sc.next();
			}
			else if(count<4 && !(st.equals("y") || st.equals("Y")))
			{
				System.out.println("enter atleast 4 subjects");
			}
			else
			{
				break;
			}
			count++;
		}
		User u1 = new User(name,age,rollno,address,subj);
		users.add(u1);
		
		
		
		
	}
}