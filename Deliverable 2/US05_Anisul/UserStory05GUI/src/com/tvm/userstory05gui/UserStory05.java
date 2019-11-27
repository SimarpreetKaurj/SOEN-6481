package com.tvm.userstory05gui;

import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author anis_huq
 *
 */
public class UserStory05 {

	static JTextField textfield1;
	String cardNumber = "";
	
	/**
	 * This method generates a simple GUI and asks the the user for
	 * bank card number as input. The result of the validity check is also
	 * displayed as output. 	
	 * @param args Supplied command-line arguments as an array of String objects.
	 */
	public static void main(String[] args) {
		
		UserStory05 userStoryObj = new UserStory05();
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame f=new JFrame("Use Case 05: Bank Card  Validity Check."); 
		JButton b=new JButton("Submit");    
		b.setBounds(100,150,120, 40);
		b.setBackground(new Color(59, 89, 182));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel label2 = new JLabel();		
		label2.setText("A credit card number must be between 13 and 16 digits.");
		label2.setBounds(10, 0, 500, 100);
		
		JLabel label3 = new JLabel();		
		label3.setText("A credit card number must start with either 4, 5, 6 or 37.");
		label3.setBounds(10, 15, 500, 100);
		
		JLabel label = new JLabel();		
		label.setText("Enter Credit/Debit card number:");
		label.setBounds(10, 50, 300, 100);
		
		JLabel label1 = new JLabel();
		label1.setBounds(110, 150, 400, 100);
		
		JTextField textfield= new JTextField();
		textfield.setBounds(10, 120, 330, 30);
				
		f.add(label2);
		f.add(label3);
		f.add(label1);
		f.add(textfield);
		f.add(label);
		f.add(b);    
		f.setSize(400,250);
		f.setLocationRelativeTo(null);
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
						//action listener
		b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
				userStoryObj.cardNumber = textfield.getText();
				String validity = userStoryObj.cardCheckInitiation(userStoryObj.cardNumber);
				label1.setText(validity);	
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			    
			    // show a joptionpane dialog using showMessageDialog
			    JOptionPane.showMessageDialog(frame, validity);
		}          
		});
	   }
	
	/**
	 * Initiates the actual task of validity check.
	 * @param cardNumber The bank card number as String
	 * @return validity The result of validity check.
	 */
	
	public String cardCheckInitiation(String cardNumber){
		String validity = "";
		BankCard checkCardValidity = new BankCard(cardNumber);
		ArrayList<Integer> digits = checkCardValidity.convertNumber();
		if(!digits.isEmpty()){
			boolean correctStartDigit = false;
			
			if(checkCardValidity.checkValidity(digits)){//if its true
				if( (digits.get(0) == 3) && (digits.get(1) == 7) ){
					validity = "Thank you for using American Express card for your refill purchase";
					correctStartDigit = true;
				}	
				else{
						int i = digits.get(0);
						switch(i){
						case 4: validity = "Thank you for using VISA card for your refill purchase";
						correctStartDigit = true;
						break;
						case 5: validity = "Thank you for using MASTER card for your refill purchase";
						correctStartDigit = true;
						break;
						case 6: validity = "Thank you for using DISCOVER cards card for your refill purchase";
						correctStartDigit = true;
						break;
					    }
				}
			
				if(correctStartDigit == false) validity = "Card number is NOT valid."; 
			}
				
			else
				validity = "Card number is NOT valid.";
		}
		else
			validity = "Invalid card number.";
		
		return validity;
	}
	
}



