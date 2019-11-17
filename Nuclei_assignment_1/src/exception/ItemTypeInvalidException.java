/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;
//exception class
public class ItemTypeInvalidException extends Exception {
	public ItemTypeInvalidException(){
		
	}
	public ItemTypeInvalidException(String msg){
		System.out.println(msg);
	}
}
