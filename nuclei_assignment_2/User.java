
import java.io.Serializable;
import java.util.Arrays;

public class User implements Serializable{

	String name;
	int age, rollno;
	String address;
	String[] course= {"-","-","-","-","-","-"};
	
	public User(String name, int age, int rollno, String address, String[] course) {
		
		this.name = name;
		this.age = age;
		this.rollno = rollno;
		this.address = address;
		this.course = course;
	}


	@Override
	public String toString() {
		return "name=" + name + ", age=" + age + ", rollno=" + rollno + ", address=" + address + ", course="
				+ Arrays.toString(course);
	}

/*
	@Override
	public int compareTo(user o) {
		
		if(this.name==o.name )
			return this.rollno - o.rollno;
		else
			return this.name.compareToIgnoreCase(o.name);
	}
	
	*/
	
	
}