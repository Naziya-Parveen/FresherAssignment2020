/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Tax calculation
package Tax;

import exception.ItemTypeInvalidException;
import ItemStructure.Item;


public class ItemTax{
	
	public Item calculateTax(Item item) throws ItemTypeInvalidException {
		String type = item.getType();
		double tax;
		switch(type) {
			case "raw":
				tax = item.getPrice()*(12.5/100);
				item.setTax(tax);
				break;
			case "manufactured":
				tax = item.getPrice()*12.5/100;
				tax += (item.getPrice() + tax)*2/100;
				item.setTax(tax);
				break;
			case "imported":
				tax = item.getPrice()*10/100;
				if(tax + item.getPrice()<=100)
					tax += 5;
				else if(tax + item.getPrice()<=200)
					tax += 10;
				else tax += (item.getPrice() + tax)*5/100;
				item.setTax(tax);
				break;
			default: throw new ItemTypeInvalidException("Invalid Type for Item");
		}
			
		return item;
	}
}

