package com.tvm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI implements ActionListener {
    Commuter commuter = new Commuter();
    Ticket ticket = new Ticket();

    Card card = new Card();
    Bank bank = new Bank();
    Receipt receipt = new Receipt();

    double price;

    JPanel panel = new JPanel(new GridLayout(ticket.getTariffs().size(),1,4,4));
    JTextField textField =  new JTextField();
    JFrame frame = new JFrame("TVM");

    public void init(){
        textField.setText("");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        panel.setBorder(new EmptyBorder(new Insets(50, 80, 50, 80)));

        JButton jb1 = new JButton("1 Trip - 3.50$");
        JButton jb2 = new JButton("2 Trips - 6.50$");
        JButton jb3 = new JButton("Unlimited Evening - 5.50$");
        JButton jb4 = new JButton("Unlimited Weekend - 14.00$");
        JButton jb5 = new JButton("1 Day - 10.00$");
        JButton jb6 = new JButton("3 Days - 19.50$");
        JButton jb7 = new JButton("Group - 17.50$");

        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb5);
        panel.add(jb6);
        panel.add(jb7);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void paymentWindow(String s){

        String ss = s.split(" -")[0];
        System.out.println(ss);
        price = ticket.getTariffs().get(ss);
        System.out.println(price);

        JLabel label1 = new JLabel("Enter Debit/Credit card number:");

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);

        panel.add(label1);
        panel.add(textField);
        panel.add(submitButton);
        panel.add(backButton);

        panel.revalidate();
        panel.repaint();
    }

    public void receiptWindow(){
        panel.removeAll();

        JButton emailButton = new JButton("Email Receipt");
        emailButton.addActionListener(this);

        JButton paperButton = new JButton("Paper Receipt");
        paperButton.addActionListener(this);

        panel.add(emailButton);
        panel.add(paperButton);

        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Submit")) {
            if(!bank.validateCard(textField.getText())){
                JOptionPane.showMessageDialog(frame, "Invalid Card");
            }else {
                if (commuter.getCash() < price) {
                    JOptionPane.showMessageDialog(frame, "Not enough cash");
                }else{
                    receiptWindow();
                }
            }
        }else if(s.equals("Back")){
            panel.removeAll();
            panel.revalidate();
            panel.repaint();

            init();
        }else if(s.equals("Email Receipt") || s.equals("Paper Receipt")){
            JOptionPane.showMessageDialog(frame, "Receipt generated...Check US03 for full scenario");
            JOptionPane.showMessageDialog(frame, "Ticket printed");
            panel.removeAll();
            panel.revalidate();
            panel.repaint();

            init();
        }
        else{
            panel.removeAll();
            paymentWindow(s);
        }
    }
}
