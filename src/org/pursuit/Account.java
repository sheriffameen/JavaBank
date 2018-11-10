package org.pursuit;

import java.util.ArrayList;

public class Account {


    private int accountNumber;
    private String accountType;
    private double accountBalance;

    public Account (String accountType, double accountBalance){
        this.accountNumber = ((int) Math.ceil(Math.random() * 10000000));
        this.accountType = accountType;
        this.accountBalance = accountBalance;
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
        return accountType + "\nAccount Balance: " + accountBalance;
    }
}
