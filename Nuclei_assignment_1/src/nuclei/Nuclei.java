/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuclei;

import java.util.Scanner;


import ItemStructure.Item;
import Tax.ItemTax;
import exception.ItemTypeInvalidException;

public class Nuclei {

    static Scanner sc = new Scanner(System.in);;
	static ItemTax itemService = new ItemTax();
	
	public static Item getItem() {          //Take input details of an item
		Item item = new Item();
		
		System.out.println("---Enter Item details---");
		System.out.print("Name :  ");
		item.setName(sc.next());
		System.out.print("Price :  ");
		item.setPrice(sc.nextDouble());
		System.out.print("Quantity :  ");
		item.setQuantity(sc.nextInt());
		System.out.print("Type : ");
		item.setType(sc.next());
		sc.nextLine();
		
		return item;
	}
	
	public static char nextItem() {         //Check if another Item is required
		System.out.println("Do you want to enter details of any other item (y/n):");
		char res = sc.next().charAt(0);
		if(res =='n' || res== 'y') 
                    return res;
		else {
			System.out.println("Invalid Input!!! Please Enter Again");
			return nextItem();
		}
	}

	private static void itemOutput(Item item) {         //Output Item details and Final Price
		System.out.println("Item Name    		 :  " + item.getName());
		System.out.println("Item Price   		 :  " + item.getPrice());
		System.out.println("Tax per Item		 :  " + item.getTax());
		System.out.println("Total Price per Item 	 :  " + (item.getTax() + item.getPrice()));
		System.out.println("Total price for " + item.getQuantity() + " items  : " +
									" " + item.getQuantity()*(item.getTax() + item.getPrice()) );
	}
	
        public static void main(String[] args) {            //driving code
                Item item = null;
		char res = 'y';
		while(true) {
			item = getItem();
			try {
				item = itemService.calculateTax(item);
			} 
                        catch (ItemTypeInvalidException e) {
				System.out.println("Item can only be of raw, manufactured and imported type");
                                e.printStackTrace();
			}
			itemOutput(item);
			res = nextItem();
			if(res == 'n') 
                            break;
		}
    }
    
}
