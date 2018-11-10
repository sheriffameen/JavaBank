package org.pursuit;

import java.util.ArrayList;
import java.util.HashMap;

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



    public void addAccount(int accountNumber, Account account) {

        accountHashMap.put(accountNumber,account);
    }

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    HashMap<Integer,Account> accountHashMap = new HashMap<>();

    @Override
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName ;
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



