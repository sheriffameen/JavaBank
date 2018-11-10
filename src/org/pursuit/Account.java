package org.pursuit;

import java.util.ArrayList;

public class Account {


    private int accountNumber;
    private String accountType;
    private double accountBalance;
    private Customer customer;

    public Account (int accountNumber, String accountType, double accountBalance, Customer customer){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }



    @Override
    public String toString() {
        return customer+"\n"+ "Account Balance: " + accountNumber+ "\n"+ accountType + "\n"+ accountBalance ;
    }

    public double accountDeposit(double depositAmount){
        double money = depositAmount;
        System.out.println("Current Balance: "+ money);
        accountBalance = money + accountBalance;
        System.out.println("After Balance: " + accountBalance);
        return accountBalance;
    }

    public double accountWithdrawal(double withdrawalAmount){
        double money = withdrawalAmount;
        System.out.println("Current Balance: "+ money);
        accountBalance = accountBalance - money;
        System.out.println("After Balance: " + accountBalance);
        return accountBalance;
    }

    public void closeAccount(){
        accountBalance = 0;
        accountType = "Closed";

    }
}
