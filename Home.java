package nuclei_assignment_4;


//import java.util.ArrayList;

public class Home {
	

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
		Sql connect = new Sql();
		
		 connect.select();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					connect.select();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		
				
	});
		
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					connect.CalculateTaxAndUpdatePrice();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		});

		t1.start();
		t2.start();
		
		  t1.join(); 
	      t2.join();
	      
	      
	      for(Item i1: connect.finalPricedItem)
	      {
	    	  System.out.println(i1.toString());
	      }
	      
}
}