package com.tvm.userstory05gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BankCard {

	String cardNumber;
	public BankCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Converts the card number into an ArrayList of type Integer.
	 * @return an ArrayList of card number digits.
	 */
	protected ArrayList<Integer> convertNumber()
	{
		char[] tempDigits = this.cardNumber.toCharArray();
		ArrayList<Integer> digits = new ArrayList<Integer>(tempDigits.length);
		if( (tempDigits.length >= 13) && (tempDigits.length <= 16) )
		{
			for(char ch : tempDigits){
				digits.add(new Integer( Integer.valueOf( Character.toString(ch) ) ) );
			}
		}
		
		return digits;
	}
	
	/**
	 * Checks the validity of a bank card number that is provided.
	 * @param digits an ArrayList of card number digits.
	 * @return boolean returns true if the card number is valid 
	 */
	protected boolean checkValidity(ArrayList<Integer> digits){
		//deep copy in a new array list.
		ArrayList<Integer> digitsClone = Clone(digits);
		//start 
		Collections.reverse(digitsClone);//because the algorithm goes from right to left. 
		int cloneOddTotal = 0;
		for(int i = 1; i < digitsClone.size(); i = i + 2 ){
			int num = digitsClone.get(i) * 2;
			if(num >= 10){
				int digitTotal = 0;
				while(num > 0)				{
					digitTotal = digitTotal + (num % 10);
					num = num / 10;
				}
				cloneOddTotal = cloneOddTotal + digitTotal;
			}
			else
				cloneOddTotal = cloneOddTotal + num;
		}
		
		//System.out.println("clone odd Total:  "+cloneOddTotal);
		
		digitsClone = Clone(digits);
		Collections.reverse(digitsClone);//because the algorithm goes from right to left. 
		int oddTotal = 0;
		for(int i = 0; i < digitsClone.size(); i = i + 2){
			oddTotal = oddTotal + digitsClone.get(i);
		}
		
		//System.out.println("odd Total:  "+oddTotal);
		
		int total = cloneOddTotal + oddTotal;
		
		if(total % 10 == 0) return true;
		else return false;
	}
	
	/**
	 * Clones (deep copy) of an ArrayList. 
	 * @param digits an ArrayList of card number digits.
	 * @return
	 */
	private ArrayList<Integer> Clone(ArrayList<Integer> digits){
		ArrayList<Integer> digitsClone = new ArrayList<>();
		Iterator<Integer> iterator = digits.iterator();
		 
		while(iterator.hasNext()){
		    digitsClone.add(iterator.next());  
		}
		
		return digitsClone;
	}
	
	
	public String getCardNumber() {
		return cardNumber;
	}



}
