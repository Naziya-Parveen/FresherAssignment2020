
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;

public class saveDetails {
	
	public void save()
	{
		
		try {
			FileOutputStream file = new FileOutputStream("userdata.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject((ArrayList<User>) addUser.users);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Added to disk");
	}

}