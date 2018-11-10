package org.pursuit;

import java.util.*;

import static javax.swing.UIManager.get;

public class Main {


    private String accountType;
    private double accountBalance;
    private Customer customerAccount;


    public static void main(String[] args) {
        Main main = new Main();
        main.bankTeller();
    }


    private HashMap<Customer, Account> customerMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Scanner input = scanner;


    private void presetAccounts() {
        Customer sheriffAmeen = new Customer();
        sheriffAmeen.setFirstName("Sheriff");
        sheriffAmeen.setLastName("Ameen");
        sheriffAmeen.addAccount("Checking", 999);
        customerMap.put(sheriffAmeen, new Account(accountType, accountBalance));

        Customer jarettAnderson = new Customer();
        jarettAnderson.setFirstName("Jarett");
        jarettAnderson.setLastName("Anderson");
        jarettAnderson.addAccount("Savings", 300);
        customerMap.put(jarettAnderson, new Account(accountType, accountBalance));

        Customer waheedAmeen = new Customer();
        waheedAmeen.setFirstName("Waheed");
        waheedAmeen.setLastName("Ameen");
        waheedAmeen.addAccount("Checkings", 250);
        customerMap.put(waheedAmeen, new Account(accountType, accountBalance));

        Customer angelaAlston = new Customer();
        angelaAlston.setFirstName("Angela");
        angelaAlston.setLastName("Alston");
        angelaAlston.addAccount("Savings", 600);
        customerMap.put(angelaAlston, new Account(accountType, accountBalance));

        Customer arielPaulino = new Customer();
        arielPaulino.setFirstName("Ariel");
        arielPaulino.setLastName("Paulino");
        arielPaulino.addAccount("Checking", 800);
        customerMap.put(arielPaulino, new Account(accountType, accountBalance));








    }

    private void bankTeller() {
        signOn();
        homePage();
    }


    private void signOn() {
        String inputUsername;
        String inputPassword;
        do {// do this stuff while the program is running
            System.out.println("Username: ");// System prints out enter username
            String userName = "SheriffA";// initializing the username
            String password = "1992";// initializing the password
            inputUsername = input.nextLine(); // initializing User input username
            if (inputUsername.equals(userName)) {// if the user enters in the right username it goes to the password
                do {
                    System.out.println("Enter Password: ");//System prints to Enter password
                    inputPassword = input.nextLine();// initializing user input password
                    if (inputPassword.equals(password)) { //If the user enters the right password they go into the homepage
                        homePage();
                    } else {
                        System.out.println("Sorry, please enter again...");// every time the user enters in the wrong username
                    }
                } while (!inputPassword.equals("1992"));
            } else {
                System.out.println("Sorry, please enter again...");// every time the user enters in the wrong username
            }
        } while (!inputUsername.equals("SheriffA"));
    }

    private void homePage() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome");
        System.out.println("What would you like to do?\n[1]Create\n[2]View\n[3]Delete");
        int homeInput = scanner.nextInt();

        switch (homeInput) {

            case 1:
                createCustomer();
                homePage();
                break;
            case 2:
                viewHomePage();
                homePage();
                break;
            case 3:
                deleteCustomer();
                homePage();
                break;
        }
    }

    private Customer createCustomer() {
        System.out.println("What is the customers first name? ");
        String firstName = scanner.next();
        System.out.println("What is the customers last name? ");
        String lastName = scanner.next();
        System.out.println("What type of account would you like to open?[Checking]/[Savings]");
        String accountType = scanner.next();
        System.out.println("How much would the customer like to deposit? ");
        double accountBalance = scanner.nextDouble();

        //homePage();

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.addAccount(accountType, accountBalance);

        customerMap.put(customer, new Account(accountType, accountBalance));

        System.out.println("New Account Added!\n" + customer);

        return customer;
    }

    private void viewHomePage() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("What would you like to do?\n[1]View A Customer \n[2]View All Customers\n[3]Home Page");
        int viewInput = scanner.nextInt();

        switch (viewInput) {

            case 1:
                System.out.println("What is the first name of the Account you would like to view?");
                String firstName = scanner.nextLine();
                System.out.println("What is the last name of the Account you would like to view?");
                String lastName = scanner.nextLine();

                getAccountByCustomerName(firstName, lastName);

                break;
            case 2:
                viewAllCustomers();
                viewHomePage();
                break;
            case 3:
                homePage();
                break;
        }

    }

    private void viewAllCustomers() {
        presetAccounts();

        for (Customer key : customerMap.keySet()) {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(key);
        }
    }

    private Account getAccountByCustomerName(String firstName, String lastName) {
        for (Customer customer : customerMap.keySet()) {
            //firstName = scanner.nextLine();
            //System.out.println("What is the last name of the Account you would like to view?");
            //lastName = scanner.nextLine()
            // System.out.println("----------------------------------------------------------------------------------------------------------");
            if (customer.getFirstName().equals(firstName)&& customer.getLastName().equals(lastName)){
                return customerMap.get(customer);
            }
        }return null;
    }

    private void deleteCustomer() {
        System.out.println("Hello3");
    }
}

