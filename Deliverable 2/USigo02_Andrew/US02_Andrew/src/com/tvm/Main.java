package com.tvm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GUI gui = new GUI();

        gui.init();


        // Define new buttons



//        do {
//            System.out.println("Please choose a ticket\n");
//            ticket.getTariffs().forEach((key, value) -> System.out.println(key + " $" + value));
//            System.out.println("\nInput: ");
//            input = reader.nextLine();
//        }while(!ticket.getTariffs().containsKey(input));
//
//        double price = ticket.getTariffs().get(input);
//
//        do {
//            System.out.println("Enter Card Number");
//            System.out.println("\nInput: ");
//        }while(!bank.validateCard(reader.next()));
//
//        if(price > commuter.getCash()){
//            System.out.println("Not enough cash");
//            return;
//        }
//
//        do{
//            System.out.println("Enter receipt preference:");
//            receipt.getTypes().forEach(System.out::println);
//            System.out.println("\nInput:");
//        }while (!receipt.getTypes().contains(reader.next()));
//
//        System.out.println("Receipt generated...Refer to US03 for a complete scenario");
//
//        System.out.println("Ticket printed");
    }
}
