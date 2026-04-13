/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main { 
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        // Registration
        System.out.println("=== Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number (with country code, e.g. +27...): ");
        String phoneNumber = scanner.nextLine();

        String registrationMessage = loginSystem.registerUser(username, password, phoneNumber);
        System.out.println(registrationMessage);

        // If registration successful, proceed to login
        if (registrationMessage.equals("User registered successfully")) {
            System.out.println("\n=== Login ===");
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            boolean loginSuccess = loginSystem.loginUser(enteredUsername, enteredPassword);

            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            String loginMessage = loginSystem.returnLoginStatus(loginSuccess, firstName, lastName);
            System.out.println(loginMessage);
        }

        scanner.close();
    }
    
}

