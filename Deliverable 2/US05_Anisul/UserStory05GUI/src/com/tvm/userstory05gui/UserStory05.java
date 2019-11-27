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
public class UserStory05 extends JFrame implements ActionListener{

	static JTextField textfield1;
	JFrame f = null;
	JPanel p = null;
	String cardNumber = "";
	
	/**
	 * This method generates a simple GUI and asks the the user for
	 * input.  	
	 * @param args Supplied command-line arguments as an array of String objects.
	 */
	public static void main(String[] args) {
		
		UserStory05 userStoryObj = new UserStory05();
		userStoryObj.firstWindow();
		
}
	/**
	 * Generates the initial window screen.
	 */
	public void firstWindow(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		f = new JFrame("Use Case 05: Refill Amounts Options"); 
		
		p = new JPanel();
		
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		JButton jb1 = new JButton("2 weeks - 40  CAD");
		jb1.addActionListener(this);
		
		JButton jb2 = new JButton("1 Month - 80  CAD");
		jb2.addActionListener(this);
		
		JButton jb3 = new JButton("2 Month - 150 CAD");
		jb3.addActionListener(this);
		
        JButton jb4 = new JButton("3 Month - 210 CAD");
        jb4.addActionListener(this);
        
        p.add(Box.createVerticalStrut(10));
		p.add(jb1);
		p.add(Box.createRigidArea(new Dimension(120, 0)));
		p.add(Box.createVerticalStrut(10));
		p.add(jb2);
		p.add(Box.createVerticalStrut(10));
		p.add(jb3);
		p.add(Box.createVerticalStrut(10));
		p.add(jb4);
		
		f.getContentPane().add(p);
		f.setSize(400,250);
		f.setLocationRelativeTo(null);
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }
	
	public void actionPerformed(ActionEvent e) {
		p.removeAll();
		p.revalidate();
		p.repaint();
		f.dispose();
		
		UserStory05 userStoryObj = new UserStory05();
		userStoryObj.secondWindow(userStoryObj);
    }  

	
	/**
	 * Generates the second window screen.
	 * @param userStoryObj object reference of type UserStory05
	 */
	public void secondWindow(UserStory05 userStoryObj){
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
				//label1.setText(validity);	
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
