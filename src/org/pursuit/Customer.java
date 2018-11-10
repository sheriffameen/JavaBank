package org.pursuit;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;
    private Account account;

    public Customer(){

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAccountNumber(){
        return account.getAccountNumber();
    }

    public void addAccount(String accountType,double accountBalance) {

        this.account = new Account(accountType,accountBalance);
    }

    public void Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nAccount: " + account;
    }

    //    public Customer() {
//    }
//
//    public Customer(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//
//    }


}



