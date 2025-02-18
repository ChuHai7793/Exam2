package controller;

import model.BankAccount;
import model.PayAccount;
import model.SavingAccount;
import storage.ReadFileCSV;
import storage.WriteFileCSV;
//import storage.WriteFileCSV;

import java.util.List;
import java.util.Scanner;

public class Manager {

    private final List<BankAccount> accountsList = ReadFileCSV.readCsvFile();
    // SINGLETON DESIGN PATTERN
    // Step 1: Create a private static instance of the class
    private static Manager manager;
    // Step 2: Private constructor to prevent instantiation from outside
    private Manager() {}
    // Step 3: Public method to provide access to the single instance
    public static Manager getInstance() {
        if (manager == null) {
            manager = new Manager(); // Create the instance if it doesn’t exist
        }
        return manager;
    }

    public List<BankAccount> getAccountsList() {
        return accountsList;
    }

    // THEM ACCOUNT
    public void addAccount(BankAccount account) {
        accountsList.add(account);
        WriteFileCSV.writeToFile(accountsList);
    }

    public void addPayAccount(Scanner scanner) {
        int accountID = accountsList.get(accountsList.size() - 1).getAccountID()+1;
        System.out.println("Enter account code:");
        String code = scanner.nextLine();
        System.out.println("Enter account owner name: ");
        String owner = scanner.nextLine();
        System.out.println("Enter date created: ");
        String date = scanner.nextLine();
        System.out.println("Enter cart No: ");
        String cardNo = scanner.nextLine();
        System.out.println("Enter balance: ");
        double balance = scanner.nextDouble();

        BankAccount payAccount = new PayAccount(accountID, code, owner,date, cardNo,balance);
        addAccount(payAccount);
    }

    public void addSavingAccount(Scanner scanner) {
        int accountID = accountsList.get(accountsList.size() - 1).getAccountID()+1;
        System.out.println("Enter account code:");
        String code = scanner.nextLine();
        System.out.println("Enter account owner name: ");
        String owner = scanner.nextLine();
        System.out.println("Enter date created: ");
        String date = scanner.nextLine();
        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Enter deposit date: ");
        String depositDate = scanner.nextLine();
        System.out.println("Enter due date: ");
        String dueDate = scanner.nextLine();
        System.out.println("Enter interest date: ");
        double balance = scanner.nextDouble();

        BankAccount savingAccount = new SavingAccount(accountID, code, owner,date,
                amount,depositDate,dueDate,balance);
        addAccount(savingAccount);

    }

    public boolean isExistAccount(String accountCode) {
        boolean isExist = false;
        for (BankAccount account : accountsList) {
            if (account.getAccountCode().equals(accountCode)) {
                isExist = true;
            }
        }
        return isExist;

    }
    public void removeAccount(Scanner scanner) {
        System.out.println("Enter account code:");
        String accountCode = scanner.nextLine();

        if (isExistAccount(accountCode)){
            System.out.println("Do you want to delete this account? (Y/N):");
            String choice = scanner.nextLine();

            if (choice.equals("Yes")) {
                for (BankAccount account : accountsList) {
                    if (account.getAccountCode().equals(accountCode)) {
                        accountsList.remove(account);
                    }
                }
            } else if(choice.equals("No")) {

            } else {}
        }

        WriteFileCSV.writeToFile( accountsList);
    }
    public void searchAccount(Scanner scanner) {
        System.out.println("Enter account id to search:");
        String accountId = scanner.nextLine();
        Boolean isExist = false;
        for (BankAccount account : accountsList) {
            if (account.getAccountID() == Integer.parseInt(accountId)) {
                System.out.println(account);
                isExist = true;
            }
        }
        if (!isExist) {
            System.out.println("Account not found");
        }
    }


}
