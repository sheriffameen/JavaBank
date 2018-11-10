package org.pursuit;

import sun.print.CUPSPrinter;

import java.util.*;

import static javax.swing.UIManager.get;

public class Main {

    private int accountNumber;
    private String accountType;
    private double accountBalance;


    public static void main(String[] args) {
        Main main = new Main();
        main.bankTeller();
    }


    private HashMap<Customer, Account> customerMap = new HashMap<>();
    private Scanner input = new Scanner(System.in);
    private HashMap<Integer, Account> accountMap = new HashMap<>();
    private ArrayList<Customer> customerList = new ArrayList<>();
    private HashSet<String> questions = new HashSet<>();


    private void presetAccounts() {
        Customer sheriffAmeen;
        sheriffAmeen = new Customer("Sheriff", "Ameen");
        Account account = new Account(123452, "Checking", 999, sheriffAmeen);
        sheriffAmeen.addAccount(account.getAccountNumber(), account);
        customerMap.put(sheriffAmeen, account);
        accountMap.put(account.getAccountNumber(), account);
        customerList.add(sheriffAmeen);

        Customer jarettAnderson;
        jarettAnderson = new Customer("Jarett", "Anderson");
        account = new Account(123453, "Checking", 700, jarettAnderson);
        jarettAnderson.addAccount(account.getAccountNumber(), account);
        customerMap.put(jarettAnderson, account);
        accountMap.put(account.getAccountNumber(), account);
        customerList.add(jarettAnderson);

        Customer waheedAmeen;
        waheedAmeen = new Customer("Waheed", "Ameen");
        account = new Account(123454, "Checking", 546, waheedAmeen);
        waheedAmeen.addAccount(account.getAccountNumber(), account);
        customerMap.put(waheedAmeen, account);
        accountMap.put(account.getAccountNumber(), account);
        customerList.add(waheedAmeen);

        Customer angelaAlston;
        angelaAlston = new Customer("Angela", "Alston");
        account = new Account(123455, "Checking", 250, angelaAlston);
        angelaAlston.addAccount(account.getAccountNumber(), account);
        customerMap.put(angelaAlston, account);
        accountMap.put(account.getAccountNumber(), account);
        customerList.add(angelaAlston);

        Customer arielPaulino = new Customer();
        arielPaulino = new Customer("Ariel", "Paulino");
        account = new Account(123456, "Checking", 700, arielPaulino);
        arielPaulino.addAccount(account.getAccountNumber(), account);
        customerMap.put(arielPaulino, account);
        accountMap.put(account.getAccountNumber(), account);
        customerList.add(arielPaulino);

        questions.add("What do you want to do?");

    }

    private void bankTeller() {
        logo();
        signOn();
        homePage();
    }

    private void logo(){
        System.out.println("     _._._                       _._._\n" +
                "        _|   |_                     _|   |_\n" +
                "        | ... |_._._._._._._._._._._| ... |\n" +
                "        | ||| |  o NATIONAL BANK o  | ||| |\n" +
                "        | \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |\n" +
                "   ())  |[-|-]| [-|-]  [-|-]  [-|-] |[-|-]|  ())\n" +
                "  (())) |     |---------------------|     | (()))\n" +
                " (())())| \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |(())())\n" +
                " (()))()|[-|-]|  :::   .-\"-.   :::  |[-|-]|(()))()\n" +
                " ()))(()|     | |~|~|  |_|_|  |~|~| |     |()))(()\n" +
                "    ||  |_____|_|_|_|__|_|_|__|_|_|_|_____|  ||\n" +
                " ~ ~^^ @@@@@@@@@@@@@@/=======\\@@@@@@@@@@@@@@ ^^~ ~\n" +
                "      ^~^~                                ~^~^");

        System.out.println("|    \\| |      /  _] /    |/ ___/  /  _]     / ___/|    | /    ||    \\     |    ||    \\ \n" +
                "|  o  ) |     /  [_ |  o  (   \\_  /  [_     (   \\_  |  | |   __||  _  |     |  | |  _  |\n" +
                "|   _/| |___ |    _]|     |\\__  ||    _]     \\__  | |  | |  |  ||  |  |     |  | |  |  |\n" +
                "|  |  |     ||   [_ |  _  |/  \\ ||   [_      /  \\ | |  | |  |_ ||  |  |     |  | |  |  |\n" +
                "|  |  |     ||     ||  |  |\\    ||     |     \\    | |  | |     ||  |  |     |  | |  |  |\n" +
                "|__|  |_____||_____||__|__| \\___||_____|      \\___||____||___,_||__|__|    |____||__|__|\n" +
                "                                                                                        ");
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
                        presetAccounts();
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
        System.out.println("What would you like to do?\n[1]Create\n[2]View\n[3]Delete\n[4]Deposit\n[5]Withdrawal\n[6]Sign Out");
        System.out.println(questions);
        int homeInput = input.nextInt();

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
                deleteCustomerHomePage();
                homePage();
                break;
            case 4:
                customerDeposit();
                homePage();
                break;

            case 5:
                customerWithdrawal();
                homePage();
                break;
            case 6:
                terminateProgram();
                break;
        }
    }

    private Customer createCustomer() {
        System.out.println("What is the customers first name? ");
        String firstName = input.next();
        System.out.println("What is the customers last name? ");
        String lastName = input.next();
        System.out.println("What type of account would you like to open?[Checking]/[Savings]");
        String accountType = input.next();
        System.out.println("How much would the customer like to customerDeposit? ");
        double accountBalance = input.nextDouble();
        int accountNumber = ((int) Math.ceil(Math.random() * 10000000));
        //homePage();

        Customer customer = new Customer();
        Account account = new Account(accountNumber, accountType, accountBalance, customer);

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.addAccount(account.getAccountNumber(), account);


        customerMap.put(customer, account);
        accountMap.put(accountNumber, account);

        System.out.println("New Account Added!\n" + customer + accountNumber);

        return customer;
    }

    private void viewHomePage() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println("What would you like to do?\n[1]View A Customer \n[2]View All Customers\n[3]Home Page");
        int viewInput = input.nextInt();

        switch (viewInput) {

            case 1:
                getAccountByCustomerName();
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

    private Integer getAccountByCustomerName() {
        System.out.println("What is the account number to the account you would like to view");
        int userAccountNumberInput = input.nextInt();

        for (int integer : accountMap.keySet()) {
            if (integer == userAccountNumberInput) {
                System.out.println(accountMap.get(integer));
                return integer;
            }
        }
        return null;
    }

    private void viewAllCustomers() {

        for (Customer key : customerMap.keySet()) {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(key);
            int tempAccountNumber = customerMap.get(key).getAccountNumber();
            String tempAccountType = customerMap.get(key).getAccountType();
            double tempAccountBalance = customerMap.get(key).getAccountBalance();
            System.out.println("Account Number: " + tempAccountNumber + "\nAccount Type: " + tempAccountType + "\nAccount Balance: " + tempAccountBalance);

        }
    }


    private void deleteCustomerHomePage() {
        System.out.println("----------------------------------------------------------------------------------------------------------");
        String[] options = {"[1]Close Account","[2]Delete Account"};
        System.out.println(Arrays.toString(options));
        int deleteCustomerHomePage = input.nextInt();

        switch (deleteCustomerHomePage){
            case 1:
                input.nextLine();
                closeAccount();
                homePage();
                break;

            case 2:
                input.nextLine();
                deleteAccount();
                homePage();
                break;
        }
    }

    private void customerDeposit() {
        System.out.println("What account would you like to Deposit funds?");
        int accountNumber = input.nextInt();
        if (accountMap.containsKey(accountNumber)) {
            Account customer = accountMap.get(accountNumber);
            System.out.println(customer.getCustomer() + "\n" + customer.getAccountType() + "\n" + customer.getAccountBalance());
            System.out.println("Enter customerDeposit amount:");
            double depositAmount = input.nextDouble();
            customer.accountDeposit(depositAmount);
            System.out.println("Customer Balance is now " + customer.getAccountBalance());
        } else {
            System.out.println("Wrong");
            System.out.println(accountMap.keySet());
            homePage();
        }
    }

    private void customerWithdrawal(){
        System.out.println("What account would you like to Withdrawal funds?");
        int accountNumber = input.nextInt();
        if (accountMap.containsKey(accountNumber)){
            Account customer = accountMap.get(accountNumber);
            System.out.println(customer.getCustomer() + "\n" + customer.getAccountType() + "\n" + customer.getAccountBalance());
            System.out.println("Enter customer Withdrawal amount:");
            double withdrawalAmount = input.nextDouble();
            customer.accountWithdrawal(withdrawalAmount);
            System.out.println("Customer Balance is now " + customer.getAccountBalance());
        } else {
            System.out.println("Account Number not found");
            System.out.println(accountMap.keySet());
            homePage();
        }
        }

        private void closeAccount(){
            System.out.println("What account would you like to close?");
            int accountNumber = input.nextInt();
            if(accountMap.containsKey(accountNumber)){
                Account customer = accountMap.get(accountNumber);
                customer.closeAccount();
                System.out.println(customer.getCustomer() + "\n" + customer.getAccountType() + "\n" + customer.getAccountBalance());

            }
        }

        private void deleteAccount(){
            Customer customer = new Customer();
            System.out.println("What is the first name you would like to delete?");
            String firstName = input.nextLine();
            System.out.println("What is the last name of the account you would like to delete?");
            String lastName = input.nextLine();

            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            for (Customer customer1 : customerMap.keySet())
            if (customer1.getFirstName().equals(firstName) && customer1.getLastName().equals(lastName)){
                customer = customer1;

            }
            customerMap.remove(customer);
            System.out.println(customer+ " \nDeleted!");

        }

    private void terminateProgram() {
        String[] exitMessage = {"Have", " a", " nice", " day", "!!!"};
        for (int i = 0; i < exitMessage.length; i++) {
            System.out.print(exitMessage[i]);
        }
        System.exit(0);
    }




    }



