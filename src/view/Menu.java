package view;

import controller.Manager;
import model.BankAccount;

import java.util.List;
import java.util.Scanner;


public class Menu {

    public void DisplayMenu() {
        try{
            while(true) {
                Scanner scanner = new Scanner(System.in);
                Manager manager =  Manager.getInstance();

                System.out.println(" Chon chuc nang theo so ( de tiep tuc) ");
                System.out.println("1: Them moi");
                System.out.println("2: Xoa");
                System.out.println("3: Xem danh sach cac tai khoan ngan hang");
                System.out.println("4: Tim kiem");
                System.out.println("5: Thoat");
                System.out.println("Chon Chuc Nang:");

                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 5) {
                    System.out.println("EXIT!");
                    break;
                }
                switch (choice) {
                    case 1:
                        addAccount(scanner, manager);
                        break;
                    case 2:
//                        removeAccount(scanner, manager);
                        break;

                    case 3:
                        showAllAccounts(manager);
                        break;
                    case 4:
                        searchAccount(scanner, manager);
                        break;
                    default:

                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addAccount(Scanner scanner, Manager manager) {
        try {
            while(true) {
                System.out.println("1:Add PayAccount");
                System.out.println("2:Add SavingsAccount");
                System.out.println("0:Back");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    System.out.println("BACK TO MAIN MENU");
                    break;
                }
                switch (choice) {
                    case 1:
                        manager.addPayAccount(scanner);
                        break;
                    case 2:
                        manager.addSavingAccount(scanner);
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void showAllAccounts( Manager manager) {

        List<BankAccount> accountList = manager.getAccountsList();

        for (BankAccount account : accountList) {
            System.out.println(account);
        }
    }

    public static void removeAccount(Scanner scanner, Manager manager) {
        manager.removeAccount(scanner);
    }

    public static void searchAccount(Scanner scanner, Manager manager) {
        manager.searchAccount(scanner);
    }
}
