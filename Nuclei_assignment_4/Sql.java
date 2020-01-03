package nuclei_assignment_4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Sql {

	private static ArrayList<Item> item = new ArrayList<>();
	
	public ArrayList<Item> finalPricedItem = new ArrayList<>();
	
	private static boolean stopCalculation=true;
	
	
	 public void select() throws InterruptedException{  
	        String sql = "SELECT * FROM description";
	        String url = "jdbc:mysql://localhost:3306/item";
	        
	        int maxCapacity=3;
	        try {  
	            Connection con = DriverManager.getConnection(url,"root","nuclei@123"); 
	            Statement smt  = con.createStatement();  
	            ResultSet rs    = smt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	            	synchronized(this)
	            	{
	            		if(item.size()==maxCapacity)
	            			wait();
	            	
	                Item i1= new Item(rs.getString("name"),rs.getInt("quantity"), rs.getInt("price"), rs.getString("type")); 
	                item.add(i1);
	                
	                System.out.println("Item Added");
	                notify();
	                
	                Thread.sleep(1000);
	            	}
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());
	            stopCalculation=false;
	        }
	        
	        stopCalculation=false;
	    }
	 
	 public void CalculateTaxAndUpdatePrice() throws InterruptedException
	 {
		 
		 while(stopCalculation || item.size()!=0)
		 {
			 synchronized (this) 
	         { 
	             // consumer thread waits while list 
	             // is empty 
	             while (item.size() == 0) 
	                 wait(); 
	
	             Item i1= new Item();
	             Item i =  ((List<Item>) item).get(0);
	             float tax = i1.calculateTax(i.price, i.type);
	             
	             Item itemfinal = new Item(i.name,i.quantity,((i.price+tax)*i.quantity),i.type);
	             
	             finalPricedItem.add(itemfinal);
	             ((List<Item>) item).remove(0);
	             System.out.println("Item Retrieved");
	             // Wake up producer thread 
	             notify(); 
	
	             //sleep 
	             Thread.sleep(1000); 
	         } 
		 }
		 
	 }
	
}
