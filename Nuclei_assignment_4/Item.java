package nuclei_assignment_4;

public class Item {

	String name;
	int quantity;
	float price;
	String type;
	
	public Item()
	{
		
	}
	
	public Item(String name, int quantity, float price, String type)
	{
		
		this.name=name;
		this.quantity=quantity;
		this.price= price;
		this.type=type;
		
	}

	public float calculateTax(float price, String type)
	{
		float tax=0.0f;
		
		try
		{
		if(type.equals("raw"))
			{
				tax=(float)(0.125*price);
			}
		else if(type.equals("manufactured"))
			{
				float taxi=(float)(0.125*price);
				float tax1=(float)(0.2 *(taxi+price));
				tax=taxi+tax1;
			}
		else if(type.equals("imported"))
			{
				tax=(float) (0.1*price);
				if(price+tax <= 100)
				{
					tax+=5;
				}
				else if (price+tax >100 && price+tax <=200)
				{
					tax+=10;
				}
				else
				{
					tax=(float)(0.05*(tax+price));
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return tax;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", quantity=" + quantity + ", price=" + price + ", type=" + type + "]";
	}
	
	
}