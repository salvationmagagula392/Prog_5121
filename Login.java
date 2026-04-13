/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    // 1. Check Username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Check Password Complexity
    public boolean checkPasswordComplexity(String password) {
        boolean length = password.length() >= 8;
        boolean uppercase = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*[0-9].*");
        boolean specialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return length && uppercase && number && specialChar;
    }

    // 3. Check Cell Phone Number (Regex)
    public boolean checkCellPhoneNumber(String phoneNumber) {
        // Regex: +countryCode followed by up to 10 digits
        return phoneNumber.matches("^\\+\\d{1,3}\\d{10}$");
    }

    // 4. Register User
    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.storedPhone = phoneNumber;

        return "User registered successfully";
    }

    // 5. Login User
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }

    // 6. Return Login Status
    public String returnLoginStatus(boolean loginSuccess, String firstName, String lastName) {
        if (loginSuccess) {
            return "Welcome " + firstName + " " + lastName + " - it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}